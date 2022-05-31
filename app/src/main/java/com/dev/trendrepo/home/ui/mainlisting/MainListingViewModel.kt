package com.dev.trendrepo.home.ui.mainlisting
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.trendrepo.data.model.GetRepoModel
import com.dev.trendrepo.repository.GetCategoryRepository
import com.dev.trendrepo.utils.NetworkUtil.Companion.hasInternetConnection
import com.dev.trendrepo.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject
@HiltViewModel
class MainListingViewModel @Inject constructor(
    private val getCategoryRepository: GetCategoryRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {
    val getcategories: MutableLiveData<Resource<GetRepoModel>> = MutableLiveData()
    var categoryResponse: GetRepoModel? = null
    init {
        getcategorylist()
    }
    fun getcategorylist() = viewModelScope.launch {
        safeGetCategoryCall()
    }

    private suspend fun safeGetCategoryCall(){
        getcategories.postValue(Resource.Loading())
        try{
            if(hasInternetConnection(context)){
                val response = getCategoryRepository.getCategoryList()
                getcategories.postValue(handleGetCategoryListResponse(response))
            }
            else{
                getcategories.postValue(Resource.Error("No Internet Connection"))
            }
        }
        catch (ex : Exception){
            when(ex){
                is IOException -> getcategories.postValue(Resource.Error("Network Failure"))
                else -> getcategories.postValue(Resource.Error("Conversion Error"))
            }
        }
    }

    private fun handleGetCategoryListResponse(response: Response<GetRepoModel>): Resource<GetRepoModel> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                if (categoryResponse == null)
                    categoryResponse = resultResponse
                else {

                }
                return Resource.Success(categoryResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}