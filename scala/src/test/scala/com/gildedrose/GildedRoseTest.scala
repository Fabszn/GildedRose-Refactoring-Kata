package com.gildedrose

import org.scalatest._

//"Aged Brie" ,   "Backstage passes to a TAFKAL80ETC concert","Sulfuras, Hand of Ragnaros"

class GildedRoseTest extends FlatSpec with Matchers {
  "item(s)" should "foo" in {
    val items = Array[Item](Item("foo", 0, 0))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).name) should equal("foo")
  }

  it should "foo & bar" in {
    val items = Array[Item](Item("foo", 0, 0),Item("bar", 0, 0))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).name) should equal("foo")
    (app.items(1).name) should equal("bar")
  }

  "Quality" should "increased by one for Aged Brie & Backstage passes to a TAFKAL80ETC concert " in {
    val items = Array[Item](Item("Aged Brie", 8, 15)
      , new Item("Backstage passes to a TAFKAL80ETC concert", 35, 20))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal(16)
    (app.items(1).quality) should equal(21)

  }

  it should "increased by 2 for Backstage passes to a TAFKAL80ETC concert " in {
    val items = Array[Item](Item("Backstage passes to a TAFKAL80ETC concert", 10, 20))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal(22)


  }

  it should "drops to 0 after the concert " in {
    val items = Array[Item](Item("Backstage passes to a TAFKAL80ETC concert", 0, 20))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal(0)


  }
  it should "increased by 3 for Backstage passes to a TAFKAL80ETC concert " in {
    val items = Array[Item](Item("Backstage passes to a TAFKAL80ETC concert", 5, 20))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal(23)
  }

  it should "decreased by two" in {
    val items = Array[Item](Item("foo", 0, 2))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal(0)
  }

  "Sulfuras, Hand of Ragnaros" must  "never has to be sold or decreases in Quality" in {
    val items = Array[Item](Item("Sulfuras, Hand of Ragnaros", 0, 20))
    val app = new GildedRose(items)
    app.updateQuality()
    app.updateQuality()
    app.updateQuality()

    (app.items(0).quality) should equal(20)
    (app.items(0).sellIn) should equal(0)
  }

  "Aged Brie" should  "increases in Quality the older it gets" in {
    val items = Array[Item](Item("Aged Brie", 0, 20))
    val app = new GildedRose(items)
    app.updateQuality()
    app.updateQuality()
    app.updateQuality()

    (app.items(0).quality) should equal(26)
    (app.items(0).sellIn) should equal(-3)
  }


}