package com.example.gittestdemo.constant

import com.example.gittestdemo.model.FileModel

/**
 * 主要添加一些关于文档的常量
 */
 object FileConstant {
    @JvmStatic
    fun initFileList(): List<FileModel> {
        return listOf<FileModel>(
            FileModel("","ADB的一些基本操作","https://docs.qq.com/doc/DZElWZFhVVGZwQWl5"),
            FileModel("","Git的一些基本操作","https://docs.qq.com/doc/DZFlMdE5nSXFnTnJm"),
            FileModel("","SSH基本配置","https://docs.qq.com/doc/DZEhYc3VHYkphd2tE"),
            FileModel("","项目编译","https://docs.qq.com/doc/DZFlMdE5nSXFnTnJm"),
            FileModel("","android百科","https://docs.qq.com/doc/DZHlreUhzY0VYRHlT"),

            FileModel("","更多请自行添加",""),
        )
    }

     const val FILE_LINK = "file_link" //文档链接
     const val FILE_NAME = "file_name" //文档名字
}