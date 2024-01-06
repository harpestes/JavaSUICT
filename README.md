# Лабораторна робота №8

## Функціональність програми

**Програма звертається до API, отримує дані та зберігає їх**

## Опис роботи

1. Створити моделі для збереження даних
    - [Category]
    - [Product]
    - [User]
2. Створити клієнтський клас, який буде звертатися до API
    - [Client]
3. Створити DTO клас, що буде зберігати лише потрібні дані
    - [ProductDTO]
4. Створити клас-mapper, що буде конвертувати початковий клас Product в ProductDTO
    - [ProductMapper]
5. Додати клас з реалізацією створення таблиці:
    - [TableConstructor]
6. Створити демонстраційний клас, який продемонструє функціональність програми та збереже усі дані у формі таблиці
    - [APIDemo]

## Висновок

**Під час лабораторної роботи я навчився робити http запити, обробляти json відповідь та зберігати дані в Excel таблиці**

[Category]: src/main/java/org/example/model/Category.java
[Product]: src/main/java/org/example/model/Product.java
[User]: src/main/java/org/example/model/User.java
[Client]: src/main/java/org/example/controller/Client.java
[ProductDTO]: src/main/java/org/example/dto/ProductDTO.java
[ProductMapper]: src/main/java/org/example/mapper/ProductMapper.java
[TableConstructor]: src/main/java/org/example/utils/TableConstructor.java
[APIDemo]: src/main/java/org/example/APIDemo.java