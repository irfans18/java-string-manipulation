# Overview : Java String Manipulation
## Table of Contents
- [countFrequentLetterInsensitive](#countFrequentLetterInsensitive)
- [countFrequentLetterSensitive](#countFrequentLetterSensitive)

## Penjelasan Singkat
### countFrequentLetterInsensitive
Pertama, bersihkan text yang diinputkan dari _whitespace_ dan jadikan semua huruf menjadi _lowercase_.
```java
text = text.replace(" ", "").toLowerCase();
```
Kemudian, hitung frekuensi tiap huruf yang muncul dengan menggunakan map.
`map.put()` digunakan untuk menyimpan symbol atau huruf dari text yang diberikan.
`map.getOrDefault()` digunakan untuk mendapatkan value pada map berdasarkan key. ketika tidak ada maka akan memberikan nilai default sesuai yang ditentukan
```java
for (int i = 0; i < text.toCharArray().length; i++) {
    char symbol = text.toCharArray()[i];
    frequencyMap.put(symbol, frequencyMap.getOrDefault(symbol, 0) + 1);
}
```
Lalu, sorting huruf atau symbol sesuai dengan urutan text yang diberikan
```java
for (char c : text.toCharArray()) {
    String temp = c + "=" + frequencyMap.get(c) ;
    if (!list.contains(temp)) {
        list.add(temp);
    }
}
```
Setelah itu, string yang masih berbentuk list akan konversi menjadi bentuk string sesuai dengan `Output`
```java
String stringList = list.toString();
System.out.println(stringList.replace("[","\"").replace("]","\""));
```
#### Sample
Input:
```input
“We Always Mekar”
```
Output :
```output
"w=2, e=2, a=3, l=1, y=1, s=1, m=1, k=1, r=1"
```
***
Input:
```input
“coding is fun”
```
Output :
```output
"c=1, o=1, d=1, i=2, n=2, g=1, s=1, f=1, u=1"
```

### countFrequentLetterSensitive
Pertama, konversi _list of word_ menjadi sebuah string
```java
StringBuilder builder = new StringBuilder();
for (String word : words) {
    builder.append(word);
}
```

Berikutnya, hitung frekuensi setiap huruf yang muncul (_Case Sensitive_).
```java
Map<Character, Integer> frequencyMap = new HashMap<>();
for (char c : builder.toString().toCharArray()) {
    frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
}
```

Kemudian, urutkan berdasarkan `frekuensi` (_descending_)
```java
int freqCompare = b.getValue().compareTo(a.getValue());
if (freqCompare != 0) {
    return freqCompare;
}
```
Jika frekuensi sama, urutkan huruf `besar` terlebih dahulu
```java
boolean aIsLower = Character.isLowerCase(a.getKey());
boolean bIsLower = Character.isLowerCase(b.getKey());
if (aIsLower != bIsLower) {
    return aIsLower ? 1 : -1;
}
```
Jika sama-sama besar atau sama-sama kecil, urutkan berdasarkan `abjad`
```java
return Character.compare(a.getKey(), b.getKey());
```
#### Sample
Input :
```input
Input:
[“Abc”, “bCd”]
```
Output :
```output
bACcd
```
***
Input :
```input
Input:
[“Oke”, “One”]
```
Output :
```output
Oekn
```
***
Input :
```input
Input:
[“Pendanaan”, “Terproteksi”, “Untuk”, “Dampak”, “Berarti”]
```
Output :
```output
aenrktipBDPTUdmosu
```


