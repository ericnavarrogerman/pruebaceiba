package com.example.pruebaceiba.feature.post.ui.models

data class StatusView(
    var isLoading: Boolean,
    var showError: Boolean,
    var error: String,
    var data: List<ItemPost>
)