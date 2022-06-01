package com.company;

        enum ClothesSize{                           //Создать перечисление, содержащее размеры одежды (XXS, XS, S, M, L)
            XXS(38){                  //Переопределить метод getDescription - для константы XXS метод должен возвращать строку “Детский размер”
                @Override
                public String getDescription(){
                    return "Child size";      }
                                 },

            XS(40), S(42), M(46), L(50);
            int euroSize;                           //Также перечисление должно содержать числовое значение euroSize(32, 34, 36, 38, 40), соответствующее каждому размеру
            ClothesSize(int suitableParameter) {    //Создать конструктор, принимающий на вход euroSize
                euroSize = suitableParameter;  }

            public String getDescription(){         //Перечисление содержит метод getDescription, возвращающий строку "Взрослый размер"
                return "Adult size";      }

            public String toString(){
                return name() + " (" + euroSize + ") " + getDescription();
                                    }
                         }
        interface ManClothes{          //Создать интерфейсы "Мужская Одежда" с методом "одетьМужчину"
            default void toClothMan()
            { System.out.println("Dress a man"); }
                            }
        interface WomanClothes{        //"Женская Одежда" с методом "одетьЖенщину"
            default void toClothWoman()
            { System.out.println("dress a woman"); }
                            }

abstract class Garment{                //Создать абстрактный класс Одежда, содержащий переменные - размер одежды, стоимость, цвет
    private final ClothesSize size;
    private final double price;
    private final String color;

    Garment(ClothesSize size, String color, double price){
        this.size = size;
        this.price = price;
        this.color = color;                              }

    public ClothesSize getSize(){ return size; }
    public double getPrice(){ return price; }
    public String getColor(){ return color; }
                       }

class TShirt extends Garment implements ManClothes, WomanClothes{ //Создать классы наследники Одежды - Футболка (реализует интерфейсы "Мужская Одежда" и "Женская Одежда")
    TShirt(ClothesSize size, String color, double price){
        super(size, color, price);                      }

    public String toString() {
        return "\n" + "▸ TShirt size " + getSize() + "\n" + "▸ price: " + getPrice() + "₽" + "\n" + "▸ color: " + getColor();
                             }                                   }

class Trousers extends Garment implements ManClothes, WomanClothes{ //Штаны (реализует интерфейсы "Мужская Одежда" и "Женская Одежда")
    Trousers(ClothesSize size, String color, double price){
        super(size, color, price);                        }

    public String toString() {
        return "\n" + "▸ Trousers size " + getSize() + "\n" + "▸ price: " + getPrice() + "₽" + "\n" + "▸ color: " + getColor();
                             }                                    }

class Skirt extends Garment implements WomanClothes{               //Юбка (реализует интерфейсы "Женская Одежда")
    Skirt(ClothesSize size, String color, double price){
        super(size, color, price);                     }

    public String toString() {
        return "\n" + "▸ Skirt size " + getSize() + "\n" + "▸ price: " + getPrice() + "₽" + "\n" + "▸ color: " + getColor();
                             }                     }

class Tie extends Garment implements ManClothes{                    //Галстук (реализует интерфейсы "Мужская Одежда")
    Tie(ClothesSize size, String color, double price){
        super(size, color, price);                   }

    public String toString() {
        return  "\n" + "▸ Tie size " + getSize() + "\n" + "▸ price: " + getPrice() + "₽" + "\n" + "▸ color: " + getColor();
                             }                       }

class Atelier{                                     // Создать класс Ателье, содержащий методы одетьЖенщину, одетьМужчину, на вход которых будет поступать массив, содержащий все типы одежды
    void dressAMan(Garment[] clothes){             // Метод одетьЖенщину выводит на консоль всю информацию о женской одежде. То же самое для метода одетьМужчину
        System.out.println("Men's clothing\n");
        for(Garment k : clothes){
            if(k instanceof Garment){ System.out.println(k); }
                                }    }
    void dressAWoman(Garment[] clothes){
        System.out.println("Women's clothing\n");
        for(Garment c : clothes){
            if(c instanceof Garment){ System.out.println(c); }
                                }      }
             }

    public class Main{
    public static void main(String[] args) {
        Garment[] clothes = {                                            //Создать массив, содержащий все типы одежды
                new Atelier.TShirt(ClothesSize.S, "Blue", 1000),
                new Atelier.Trousers(ClothesSize.M, "Green", 2000),
                new Atelier.Skirt(ClothesSize.L, "Violet", 1300),
                new Atelier.Tie(ClothesSize.XXS, "Black", 310),
                            };

        Atelier atelier = new Atelier();
        atelier.dressAMan(clothes);
        System.out.println();
        atelier.dressAWoman(clothes);
        System.out.println();
                 }                         }

