package cl.bootcamp.kotlinconsola

fun main() {

    var array = arrayOf("Luis", "Mario", 2, 1.5, true)
    println(array.contentToString())
    println(array[1])
    println(array.size)

    var numeros = intArrayOf(1, 2, 3, 4, 5)
    println(numeros.contentToString())

    array += "Nuevo dato"
    println(array.contentToString())

    var nums = intArrayOf(5, 6, 2, 3, 8, 1)
    nums.sort()
    println(nums.contentToString())

    var nums2 = nums.toMutableList()
    nums2.remove(8)
    println(nums2)

}