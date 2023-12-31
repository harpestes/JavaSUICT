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

[City]: model/City.java
[CoordinateSearchResult]: model/CoordinateSearchResult.java
[WeatherForTheYear]: model/WeatherForTheYear.java
[YearWeather]: model/YearWeather.java
[Client]: controller/Client.java
[WeatherAnalyzer]: service/WeatherAnalyzer.java
[WeatherForTheMonth]: model/WeatherForTheMonth.java
[WeatherStatistic]: service/WeatherStatistic.java
[TableConstructor]: utils/TableConstructor.java
[WeatherAPIDemo]: WeatherAPIDemo.java