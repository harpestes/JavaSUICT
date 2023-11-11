# Лабораторна робота №2

## Функціональність програми

**Удосконалена система, яка дозволяє бібліотекареві керувати предметами (книгами, DVD) та клієнтами.**

**Система має можливість:**

- Додавати предмети (книги, DVD) до бібліотеки.
- Видаляти предмети з бібліотеки.
- Реєструвати читача.
- Видавати предмет читачеві.
- Повертати предмет у бібліотеку.
- Показувати список доступних предметів.
- Показувати список взятих предметів та їхніх читачів

## Опис роботи

- Створив абстрактний клас [Item] з полями `title`(назва елемента), `uniqueID`(ID елемента),
  `isBorrowed`(чи позичений елемент), конструктором, гетерами, сетерами і абстрактними методами `borrowItem`, `returnItem` та `idGenerator`
- Створив інтерфейс [IManageable] з методами `add`, `remove`, `listBorrowed` та `listAvailable`
- Створив класи [Book] і [DVD], які успадковуються від [Item] та реалізував методи з батьківського класу
- Створив клас [Patron] з полями `name`(ім’я клієнта), `ID`(ID клієнта) та `borrowedItems`(предмети клієнта); Створив конструктор, гетери та сетери, методи `borrowItem` та `returnItem`
- Створив клас [Library], який імплементує [IManageable], зберігає та керує об'єктами [Item] за допомогою методів `registerPatron`, `lendItem`,
  `returnItem`, `add`, `remove`, `listBorrowed`, `listAvailable` та `printer`
- Додав [тести]

## Висновок

**Під час виконання лабораторної роботи я покращив навички розробки програмного забезпечення мовою Java**

[Item]: src/main/java/org/example/Item.java 
[Book]: src/main/java/org/example/Book.java
[DVD]: src/main/java/org/example/DVD.java
[Patron]: src/main/java/org/example/Patron.java
[IManageable]: src/main/java/org/example/Interfaces/IManageble.java
[Library]: src/main/java/org/example/Library.java
[тести]: src/test/java/LibraryTest.java