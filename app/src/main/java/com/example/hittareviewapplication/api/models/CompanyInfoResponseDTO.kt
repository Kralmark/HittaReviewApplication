package com.example.hittareviewapplication.api.models


data class CompanyInfoResponseDTO(val result: CompaniesDTO)
data class CompaniesDTO(val companies: CompanyDTO)
data class CompanyDTO(val company: Array<PropertyDTO>)
data class PropertyDTO(val displayName: String)

data class ReviewDTO(
        var companyId: String,
        var userName: String = "Anonym",
        var score: Int,
        var comment: String? = null)

data class ReviewResponse(val result: Any)
