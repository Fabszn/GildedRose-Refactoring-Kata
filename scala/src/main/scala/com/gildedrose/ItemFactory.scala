package com.gildedrose

/**
 * Created by fsznajderman on 11/08/15.
 */
object ItemFactory {

  /**
   * generic trait
   */
  trait ItemService {

    val item: Item

    def updateQuality() {}

    def updateSellin() {}

    def incQuality() = {
      if (item.quality < 50) {
        item.quality += 1
      }
    }
  }

  trait ConcertItem extends ItemService {

    override def updateQuality() = {
      incQuality()

      if (item.sellIn < 11) {
        incQuality()
      }

      if (item.sellIn < 6) {
        incQuality()
      }
    }

    override def updateSellin() = {
      item.sellIn = item.sellIn - 1
      if (item.sellIn < 0) {
        item.quality = 0
      }
    }
  }

  trait LegendaryItem extends ItemService {

  }

  trait FoodItem extends ItemService {


    override def updateQuality() = {
      incQuality()
    }

    override def updateSellin() = {
      item.sellIn = item.sellIn - 1

      if (item.sellIn < 0) {
        incQuality()
      }
    }
  }

  trait DefaultItem extends ItemService {


    override def updateQuality() = {
      if (item.quality > 0) {
        item.quality = item.quality - 1
      }
    }

    override def updateSellin() = {
      item.sellIn = item.sellIn - 1
      if (item.sellIn < 0) {
        item.quality = item.quality - 1
      }
    }
  }

  case class Wrapper(item: Item)

  implicit def convertToWrapper(item: Item): ItemService = {

    item.name match {
      case "Aged Brie" => new Wrapper(item) with FoodItem
      case "Backstage passes to a TAFKAL80ETC concert" => new Wrapper(item) with ConcertItem
      case "Sulfuras, Hand of Ragnaros" => new Wrapper(item) with LegendaryItem
      case _ => new Wrapper(item) with DefaultItem
    }


  }

}
