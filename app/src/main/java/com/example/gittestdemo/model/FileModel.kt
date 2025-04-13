package com.example.gittestdemo.model

/**
 * 文档bean类
 */
data class FileModel(
    val name:String, //文档name
    val title:String, //文档title （自定义，方便浏览）
    val url:String //文档在线链接
)