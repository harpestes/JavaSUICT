# Лабораторна робота №7

## Функціональність програми

### Частина 1: Проектування Класів ###
- Product (Товар)
  - Поля: `id` (Integer), `name` (String), `price` (double), `stock` (int)
  - Реалізувати відповідні конструктори, гетери та сетери.
  - Перевизначити метод toString для правильного представлення.
- User (Користувач)
  - Поля: `id` (Integer), `username` (String), `cart` (Map<Product, Integer> представляючи Товар та Кількість)
  - Реалізувати відповідні конструктори, гетери, сетери та методи для додавання, видалення та модифікації товарів у кошику.
- Order (Замовлення)
  - Поля: `id` (Integer), `userId` (Integer), `orderDetails` (Map<Product, Integer> представляючи Товар та Кількість), `totalPrice` (double)
  - Реалізувати відповідні конструктори, гетери, сетери та метод для розрахунку загальної вартості замовлення.

### Частина 2: Платформа Електронної Комерції ###
- ECommercePlatform (Платформа Електронної Комерції)
  - Поля:
    - `users` (Map<Integer, User> - користувачі)
    - `products` (Map<Integer, Product> - товари)
    - `orders` (Map<Integer, Order> - замовлення)
  - Реалізувати методи для додавання користувачів, товарів, створення замовлення, переліку доступних товарів, переліку користувачів, переліку замовлень та оновлення запасів товарів.
- ECommerceDemo
  - Це буде ваш основний клас для демонстрації функціональності.
  - Ініціалізувати ECommercePlatform, додати користувачів та товари, симулювати взаємодію користувачів із кошиком та симулювати створення та обробку замовлень.

### Частина 3: Розширені Функції ###
- Сортування та Фільтрація
  - Реалізувати Comparable у класі Product для сортування за ціною.
  - Створіть класи Comparator для сортування Товарів за назвою та запасами.
  - У ECommerceDemo реалізувати функції для відображення списку товарів, відсортованих за назвою, ціною та запасами. Реалізувати функції для фільтрації товарів за наявністю на складі.
- Рекомендації для Користувача
  - Реалізувати функцію у ECommercePlatform для рекомендації товарів користувачам на основі товарів у їхньому кошику чи історії замовлень.

### Частина 4: Симуляція ###
- Виконання ECommerceDemo
  - У головному класі ECommerceDemo симулювати серію взаємодій користувачів, оновлень кошика, обробки замовлень, рекомендацій товарів та відобразити кінцевий стан користувачів, товарів та замовлень.

## Опис роботи

- Створив класи [Product], [User], [Order] та релізував їх поля і методи додатково додав поле `historyOfOrders` та відповідну йому реалізацію.
- Створив клас [ECommercePlatform] та реалізував його поля та методи.
- Створив клас [ECommerceDemo] в якому продемонстрував функціональність програми, а також за допомогою створених раніше класів [NameComparator] та [StockComparator] вивів відсортовані продукти.
- Написав

## Висновок

**Під час виконання лабораторної роботи я детальніше ознайомився з колекціями Java, навчився проектувати та реалізовувати класи і методи для виконання реальної задачі**

[Product]: ./src/main/java/org/example/Product.java
[User]: ./src/main/java/org/example/User.java
[Order]: ./src/main/java/org/example/Order.java
[ECommercePlatform]: ./src/main/java/org/example/ECommercePlatform.java
[NameComparator]: ./src/main/java/org/example/NameComparator.java
[StockComparator]: ./src/main/java/org/example/StockComparator.java
