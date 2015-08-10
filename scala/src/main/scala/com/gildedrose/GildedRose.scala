package com.gildedrose


/**
 * generic trait
 */
trait ItemService {
  abstract def updateQuality()

  abstract def updateSellin()
}

trait ConcertItem extends ItemService {
  def updateQuality() = {

  }

  def updateSellin() = {

  }
}

trait LegendaryItem extends ItemService {
  def updateQuality() = {

  }

  def updateSellin() = {

  }
}

trait FoodItem extends ItemService {
  def updateQuality() = {

  }

  def updateSellin() = {

  }
}


class GildedRose(val items: Array[Item]) {
  def is(name: String, idx: Int) = items(idx).name.equals(name)


  implicit def wrapper(item: Item): ItemService = {
    ???
  }

  def updateQuality() {
    for (i <- 0 until items.length) {
      if (is("Aged Brie", i) || is("Backstage passes to a TAFKAL80ETC concert", i)) {
        if (items(i).quality < 50) {
          items(i).quality = items(i).quality + 1

          if (is("Backstage passes to a TAFKAL80ETC concert", i)) {
            if (items(i).sellIn < 11) {
              if (items(i).quality < 50) {
                items(i).quality = items(i).quality + 1
              }
            }

            if (items(i).sellIn < 6) {
              if (items(i).quality < 50) {
                items(i).quality = items(i).quality + 1
              }
            }
          }
        }
      } else {
        if (items(i).quality > 0) {
          if (!is("Sulfuras, Hand of Ragnaros", i)) {
            items(i).quality = items(i).quality - 1
          }
        }
      }

      if (!is("Sulfuras, Hand of Ragnaros", i)) {
        items(i).sellIn = items(i).sellIn - 1
      }

      if (items(i).sellIn < 0) {
        if (!is("Aged Brie", i)) {
          if (!is("Backstage passes to a TAFKAL80ETC concert", i)) {
            if (items(i).quality > 0) {
              if (!is("Sulfuras, Hand of Ragnaros", i)) {
                items(i).quality = items(i).quality - 1
              }
            }
          } else {
            items(i).quality = items(i).quality - items(i).quality
          }
        } else {
          if (items(i).quality < 50) {
            items(i).quality = items(i).quality + 1
          }
        }
      }
    }
  }
}