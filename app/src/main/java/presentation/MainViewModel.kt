package presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import data.ShopItemRepositoryImpl
import domain.DeleteShopItemUseCase
import domain.EditShopItemUseCase
import domain.GetShopListUseCase
import domain.ShopItem

class MainViewModel: ViewModel() {

  private val repository = ShopItemRepositoryImpl

  private val getShopListUseCase = GetShopListUseCase(repository)

  private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)

  private val editShopItemUseCase = EditShopItemUseCase(repository)

  val shopList = getShopListUseCase.getShopList()

  fun deleteShopIem(shopItem: ShopItem) {
    deleteShopItemUseCase.deleteShopItem(shopItem)
  }

  fun changeEnabledState(shopItem: ShopItem) {
    val newItem = shopItem.copy(enabled = !shopItem.enabled)
    editShopItemUseCase.editShopItem(newItem)
  }

}