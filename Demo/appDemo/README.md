网略请求的本质 三层 决定注解的数量
三种请求标记
表单：FormUrlEncoded，文件：Multipart， 流：Streaming
* FormUrlEncoded：指请求体是一个Form表单，Content-Type=application/x-www-form-urlencoded，需要和参数类注解@Field，@FieldMap搭配使用；
* Multipart：指请求体是一个支持文件上传的Form表单，Content-Type=multipart/form-data，需要和参数类注解@Part，@PartMap搭配使用
* Streaming：指响应体的数据以流的形式返回，如果不使用默认会把数据全部加载到内存，所以下载文件时需要加上这个注解

八种请求方法
get post head delete patch put http option

11种参数类型
header headers body field fieldMap part partMap path query queryMap url


使用Post请求方式（数据都是被放在请求体中上传到服务器）：
1、表单提交：建议使用Field或FieldMap+FormUrlEncoded，以键值对上传到服务器；
2、JSON提交：建议使用@Body，大部分都是实体类，最后将实体类转换为JSON，上传服务器；

使用GET请求（将参数拼接在url后面的）
1、建议使用Query或QueryMap都是将参数拼接在url后面的；