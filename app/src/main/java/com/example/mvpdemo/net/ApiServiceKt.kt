package com.example.mvpdemo.net

import com.example.mvpdemo.bean.BaseBean
import com.example.mvpdemo.bean.UploadImageBean
import kotlinx.coroutines.Deferred
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

/**
 * api接口
 * @author ssq
 * @JvmSuppressWildcards 用来注解类和方法，使得被标记元素的泛型参数不会被编译成通配符?
 */
@JvmSuppressWildcards
interface ApiServiceKt {

    /**
     * 下载文件
     * @param fileUrl 文件地址 (这里的url可以是全名，也可以是基于baseUrl拼接的后缀url)
     * @return
     */
    @Streaming
    @GET
    fun downloadFileAsync(@Url fileUrl: String): Deferred<ResponseBody>

    /**
     * 上传图片
     * @param url 可选，不传则使用默认值
     * @param imgPath 图片路径
     * @param map     参数
     */
    @Multipart
    @POST
    fun uploadImgAsync(@Url url: String = "${ApiConstant.UPLOAD_IMAGE_URL}Upload.php",
                       @PartMap imgPath: Map<String, RequestBody>,
                       @QueryMap map: Map<String, Any>): Deferred<Response<UploadImageBean>>

    /**
     * 通用异步请求 只需要解析BaseBean
     */
    @FormUrlEncoded
    @POST("Interfaces/index")
    fun requestAsync(@FieldMap map: Map<String, Any>): Deferred<Response<BaseBean>>
}
