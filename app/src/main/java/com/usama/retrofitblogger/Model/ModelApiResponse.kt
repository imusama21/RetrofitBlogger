package com.usama.retrofitblogger.Model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class ModelApiResponse {
    @SerializedName("source")
    @Expose
    private var source: Source? = null

    @SerializedName("author")
    @Expose
    private var author: Any? = null

    @SerializedName("title")
    @Expose
    private var title: String? = null

    @SerializedName("description")
    @Expose
    private var description: String? = null

    @SerializedName("url")
    @Expose
    private var url: String? = null

    @SerializedName("urlToImage")
    @Expose
    private var urlToImage: String? = null

    @SerializedName("publishedAt")
    @Expose
    private var publishedAt: String? = null

    @SerializedName("content")
    @Expose
    private var content: Any? = null

    fun getSource(): Source? {
        return source
    }

    fun setSource(source: Source?) {
        this.source = source
    }

    fun getAuthor(): Any? {
        return author
    }

    fun setAuthor(author: Any?) {
        this.author = author
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String?) {
        this.description = description
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String?) {
        this.url = url
    }

    fun getUrlToImage(): String? {
        return urlToImage
    }

    fun setUrlToImage(urlToImage: String?) {
        this.urlToImage = urlToImage
    }

    fun getPublishedAt(): String? {
        return publishedAt
    }

    fun setPublishedAt(publishedAt: String?) {
        this.publishedAt = publishedAt
    }

    fun getContent(): Any? {
        return content
    }

    fun setContent(content: Any?) {
        this.content = content
    }
}