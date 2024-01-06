# Лабораторна робота №8

## Функціональність програми

**Програма звертається до API, отримує прогнози погоди та аналізує їх**

## Опис роботи

1. Створити моделі для збереження даних
    - [City]
    - [CoordinateSearchResult]
    - [WeatherForTheYear]
    - [YearWeather]
2. Створити клієнтський клас, який буде звертатися до API
    - [Client]
3. Створити клас, що буде аналізувати дані
    - [WeatherAnalyzer]
4. Додати модель, що буде зберігати середні значення за місяць
    - [WeatherForTheMonth]
5. Додати сервісний клас, що вираховує середні значення за кожен місяць у році
    - [WeatherStatistic]
6. Додати клас з реалізацією створення таблиць та їх виведення:
    - [TableConstructor]
7. Створити демонстраційний клас, який продемонструє функціональність програми та виведе усі дані у формі таблиць
    - [WeatherAPIDemo]

## Висновок

**Під час лабораторної роботи я навчився робити http запити, обробляти json відповідь та виводити дані в консольній таблицю**

[City]: main/java/org/example/model/City.java
[CoordinateSearchResult]: main/java/org/example/model/CoordinateSearchResult.java
[WeatherForTheYear]: main/java/org/example/model/WeatherForTheYear.java
[YearWeather]: main/java/org/example/model/YearWeather.java
[Client]: main/java/org/example/controller/Client.java
[WeatherAnalyzer]: main/java/org/example/service/WeatherAnalyzer.java
[WeatherForTheMonth]: main/java/org/example/model/WeatherForTheMonth.java
[WeatherStatistic]: main/java/org/example/service/WeatherStatistic.java
[TableConstructor]: main/java/org/example/utils/TableConstructor.java
[WeatherAPIDemo]: main/java/org/example/WeatherAPIDemo.java