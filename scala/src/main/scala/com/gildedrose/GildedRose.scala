package com.gildedrose


import com.gildedrose.ItemFactory._





class GildedRose(val items: Array[Item]) {

  def updateQuality() {

    items.foreach(item => {
      item updateQuality()
      item updateSellin()
    })
  }
}