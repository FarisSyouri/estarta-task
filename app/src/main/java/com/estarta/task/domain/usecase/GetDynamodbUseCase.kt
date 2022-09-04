package com.estarta.task.domain.usecase

import androidx.lifecycle.Transformations.map
import com.estarta.task.data.model.ItemResponse
import com.estarta.task.domain.model.Item
import com.estarta.task.domain.repository.AmazonAwsRepository
import javax.inject.Inject

class GetDynamodbUseCase @Inject constructor(private val amazonAwsRepository: AmazonAwsRepository) :
    BaseUseCase<List<Item>, BaseUseCase.None>() {

    override suspend fun execute(params: None): List<Item> = map(amazonAwsRepository.getItems())

    private fun map(response: List<ItemResponse>): List<Item> {
        return response.map {
            Item(
                it.createdAt,
                it.price,
                it.name,
                it.uid,
                it.imageUrl?.get(0),
                it.imageUrlsThumbnails?.get(0)
            )
        }
    }

}