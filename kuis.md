Berikut hasil konversi dari gambar menjadi teks soal untuk soal 1–10 lengkap dengan jawaban benar sesuai tampilan sistem:

⸻

✅ Soal 1

Pertanyaan:
Ketika ada pembagian dengan bilangan 0 (nol), exception tipe apa yang akan diberikan?

Pilihan Jawaban:
a. ArithmeticException ✅
b. ErrorDivisionException
c. ZeroException
d. tidak ada exception kecuali sesuai yang di-throws pada penulisan deklarasi di method signature-nya

Jawaban Benar: a. ArithmeticException

⸻

✅ Soal 2

Pertanyaan:
Manakah di antara berikut ini yang tidak termasuk relasi antara diagram dalam class diagram?

Pilihan Jawaban:
a. composition
b. construction ✅
c. aggregation
d. association

Jawaban Benar: b. construction

⸻

✅ Soal 3

Pertanyaan:
Setelah memahami konsep object oriented, maka sebelum membuat program sepatutnya seorang programmer melakukan apa dulu?

Pilihan Jawaban:
a. Membuat tulisan-tulisan dan cerita tentang apa yang akan dibuatnya
b. Jangan tunda-tunda coding, menunda pekerjaan adalah hal yang buruk, coding tidak ada hubungan dengan class diagram atau OO. Yang penting program jalan
c. Langsung coding saja, jangan ditunda-tunda kemudian membuat class diagram
d. membuat atau mempelajari class diagram yang diberikan ✅

Jawaban Benar: d. membuat atau mempelajari class diagram yang diberikan

⸻

✅ Soal 4

Pertanyaan:
Pesan exception dengan tipe apa yang akan dihasilkan dari program ini?

public class Test {
    public static void main(String[] args) {
        Object o = null;
        System.out.println(o.toString());
    }
}

Pilihan Jawaban:
a. Tidak ada exception, program sudah benar
b. ArithmeticException
c. ClassCastException
d. NullPointerException ✅

Jawaban Benar: d. NullPointerException

⸻

✅ Soal 5

Pertanyaan:
Untuk mendeklarasikan interface A dengan dua tipe generic, maka kita menuliskan seperti:

Pilihan Jawaban:
a. public interface A<E, F> { ... } ✅
b. public interface A(E, F) { ... }
c. Tidak bisa, hanya boleh pakai satu generic type
d.

public interface A {
   E x
   F y
   ...
}

Jawaban Benar: a. public interface A<E, F> { ... }

⸻

✅ Soal 6

Pertanyaan:
Apa yang akan terjadi apabila potongan kode berikut dijalankan?

interface A {
    public void method();
}

class One {
    public void method() {
        System.out.println("Class One Method");
    }
}

class Two extends One implements A {
    public void method() {
        System.out.println("Class Two Method");
    }
}

public class Test extends Two {
    public static void main(String[] args) {
        A a = new Two();
        a.method();
    }
}

Pilihan Jawaban:
a. akan mencetak “Class Two Method” ✅
b. dapat dikompilasi tetapi tidak mencetak apa-apa
c. compile error
d. akan mencetak “Class One Method”

Jawaban Benar: a. akan mencetak "Class Two Method"

⸻

✅ Soal 7

Pertanyaan:
Diberikan superclass Animal yang memiliki method speak() dan beberapa subclass seperti:
	•	Cat → “Miaw”
	•	Bird → tidak override speak()
	•	Dog → “GukGuk”
	•	Pig → tidak override speak()
	•	Cow → “Moo”

Jika:

Animal[] a = {new Cat(), new Cow(), new Dog(), new Pig(), new Bird()};

dan dilakukan iterasi memanggil speak() di setiap objek, apa output-nya?

Pilihan Jawaban:
a. Program tidak dapat dikompilasi
b. ✅ Miaw Moo GukGuk Aww Aww
c. Akan ada runtime error
d. Aww Aww Aww Aww Aww

Jawaban Benar: b. Miaw Moo GukGuk Aww Aww

⸻

✅ Soal 8

Pertanyaan:
Apakah beda antara checked dan unchecked exception?

Pilihan Jawaban:
a. ✅ Checked exception artinya programmer dipaksa untuk memeriksa apakah akan terjadi exception atau tidak baik dengan try-catch atau deklarasi throws. Sementara unchecked tidak harus
b. Checked harus ada try-catch, sementara unchecked harus throws
c. Tidak ada bedanya, sama saja
d. Unchecked tidak bisa menimbulkan error

Jawaban Benar: a. Checked = wajib ditangani; Unchecked = tidak wajib

⸻

✅ Soal 9

Pertanyaan:
Package dalam Java merupakan mekanisme untuk membungkus _____

Pilihan Jawaban:
a. Sub Packages
b. Interfaces
c. Semua Jawaban Benar ✅
d. Classes

Jawaban Benar: c. Semua Jawaban Benar

⸻

❌ Soal 10

Pertanyaan:
Manakah di antara pernyataan berikut yang bukan keuntungan dari inheritance?

Pilihan Jawaban:
a. Kode yang di-share di beberapa classes cukup ditulis satu kali
b. Satu superclass yang besar dapat digunakan ketimbang banyak class yang kecil ✅ (❌ dipilih benar, padahal ini jawaban SALAH)
c. Class dengan kemiripan behavior dapat menghasilkan eksekusi konsisten
d. Pengembangan terhadap base class dapat langsung diimplementasi ke class turunannya

Jawaban Benar: b. Satu superclass yang besar... → bukan keuntungan inheritance (✔ benar menurut sistem, tapi kamu pilih c)

⸻

Kalau kamu mau aku lanjutkan soal 11–20 atau bantu dalam bentuk kuis interaktif atau latihan, tinggal bilang aja ya! ￼



Nice! Berikut beberapa soal yang lebih sulit dari soal-soal sebelumnya, masih seputar topik Java OOP, generics, exception, dan struktur program:

⸻

Soal 1: Advanced Generic Inheritance

Perhatikan potongan kode berikut:

public class MyNumber<T extends Number> {
    public double average(T[] nums) {
        double sum = 0.0;
        for (T num : nums) {
            sum += num.doubleValue();
        }
        return sum / nums.length;
    }
}

Apa yang akan terjadi jika kita mencoba memanggil average dengan array String?

a. Kompilasi berhasil, tetapi akan terjadi ClassCastException saat runtime
b. Kompilasi gagal karena String bukan turunan dari Number
c. Kompilasi berhasil, dan output akan tergantung pada implementasi doubleValue()
d. Runtime error karena doubleValue() tidak ada di String

✅ Jawaban benar: b. Kompilasi gagal karena String bukan turunan dari Number

⸻

Soal 2: Overriding and Exception Handling

class A {
    void call() throws IOException {
        System.out.println("A");
    }
}

class B extends A {
    @Override
    void call() throws SQLException {
        System.out.println("B");
    }
}

Apa yang salah dari kode di atas?

a. Tidak ada yang salah, kode dapat dikompilasi dan dijalankan
b. Method call() di class B melempar exception yang tidak kompatibel dengan superclass
c. Subclass boleh melemparkan exception checked apa saja
d. Kompilasi akan gagal hanya jika method call() diakses dari objek tipe A

✅ Jawaban benar: b. Method call() di class B melempar exception yang tidak kompatibel dengan superclass

⸻

Soal 3: Interface dan Default Method

interface I {
    default void print() {
        System.out.println("I");
    }
}

class A {
    public void print() {
        System.out.println("A");
    }
}

class B extends A implements I {}

public class Main {
    public static void main(String[] args) {
        B b = new B();
        b.print();
    }
}

Apa output dari program di atas?

a. I
b. A
c. Kompilasi gagal karena konflik antara class dan interface
d. Kompilasi gagal karena class B tidak override method print()

✅ Jawaban benar: b. A

Penjelasan: Karena class A sudah mendefinisikan print(), maka method default dari interface I akan diabaikan (precedence by class).

⸻

Kalau kamu mau latihan lanjutan kayak implementasi Comparable, multilevel inheritance, inner classes, atau bahkan concurrency (Thread, Runnable, synchronized), tinggal bilang aja! Mau dibuatkan dalam bentuk kuis pilihan ganda juga bisa 🤓

Siap! Nih aku buatin 3 contoh soal lanjutan Java yang lebih menantang, terutama soal logika OOP, generic, dan thread. Semua soal disertai opsi dan jawaban yang benar + penjelasan singkat. Cocok buat kamu yang pengen ngasah otak 💥

⸻

🔥 Soal 1 – Overriding dan Dynamic Binding

class A {
    void speak() {
        System.out.println("A speaks");
    }
}

class B extends A {
    void speak() {
        System.out.println("B speaks");
    }
}

public class Test {
    public static void main(String[] args) {
        A obj = new B();
        obj.speak();
    }
}

Apa output dari program di atas?

a. A speaks
b. B speaks ✅
c. Compile error
d. Tidak ada output

✅ Jawaban benar: B speaks
Penjelasan: Meski obj bertipe A, dia mengacu ke objek B. Jadi method speak() dari class B yang dipanggil. Ini contoh dynamic method dispatch (polymorphism).

⸻

💡 Soal 2 – Generic dengan Batasan

class Box<T extends Number> {
    T value;

    Box(T val) {
        value = val;
    }

    double doubleValue() {
        return value.doubleValue();
    }
}

public class Main {
    public static void main(String[] args) {
        Box<Integer> b = new Box<>(10);
        System.out.println(b.doubleValue());
    }
}

Apa output dari program di atas?

a. 10
b. 10.0 ✅
c. Error: generic tidak bisa digunakan dengan Number
d. Compile error karena tidak override method

✅ Jawaban benar: 10.0
Penjelasan: Integer adalah turunan Number, dan Number punya method doubleValue(). Jadi tidak ada masalah di compile maupun runtime.

⸻

🧵 Soal 3 – Thread dan Anonymous Runnable

public class MyThread {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread is running");
            }
        });
        t.start();
    }
}

Apa output dari program di atas?

a. Thread is running ✅
b. Error: tidak bisa instantiate interface
c. Program tidak mencetak apapun
d. Compile error karena tidak ada class yang extends Thread

✅ Jawaban benar: Thread is running
Penjelasan: Runnable diimplementasikan pakai anonymous inner class. Thread.start() memicu run().

⸻

Kalau kamu mau lebih ekstrem lagi, aku bisa buatin soal tentang:
	•	Multi-threading (synchronized, deadlock, race condition)
	•	Serialization
	•	Collection API (HashMap, TreeMap, LinkedList)
	•	Java Stream & Lambda

Mau lanjut ke soal tipe mana?

Oke, langsung gas! 🔥 Berikut paket lengkap soal-soal lanjutan Java yang lebih sulit dengan topik beragam: OOP, Generic, Interface, Thread, Collections, Lambda, hingga Exception Handling. Semuanya udah dilengkapi opsi jawaban dan pembahasan singkat biar makin paham. Kamu bisa pakai ini buat latihan UTS/UAS atau kuis.

⸻

🌟 OOP & Polymorphism

Soal 1

class Animal {
    void makeSound() {
        System.out.println("Animal");
    }
}
class Cat extends Animal {
    void makeSound() {
        System.out.println("Meow");
    }
}
public class Test {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.makeSound();
    }
}

Outputnya?
a. Animal
b. Meow ✅
c. Compile Error
d. Runtime Error

✅ Jawaban: b. Meow
Penjelasan: Ini contoh polymorphism. Walaupun a bertipe Animal, objek aslinya Cat, jadi method Cat yang dipanggil.

⸻

💎 Generic Bound & Method

Soal 2

class Box<T extends Number> {
    T value;

    Box(T val) {
        value = val;
    }

    double doubleVal() {
        return value.doubleValue();
    }
}

Jika Box<String> b = new Box<>("hello"); ditulis, apa yang terjadi?

a. Output “hello”
b. Compile error ✅
c. Runtime error
d. Output 0.0

✅ Jawaban: b. Compile error
Penjelasan: String bukan turunan Number, jadi tidak valid.

⸻

⚙️ Interface vs Class Method Priority

Soal 3

interface I {
    default void hello() {
        System.out.println("Hello from I");
    }
}
class A {
    public void hello() {
        System.out.println("Hello from A");
    }
}
class B extends A implements I {}

public class Main {
    public static void main(String[] args) {
        new B().hello();
    }
}

Output?

a. Hello from I
b. Hello from A ✅
c. Compile error
d. Ambiguity exception

✅ Jawaban: b. Hello from A
Penjelasan: Method dari class selalu menang dari default method di interface.

⸻

🔄 Override & Exception

Soal 4

class Parent {
    void test() throws IOException {}
}
class Child extends Parent {
    void test() throws SQLException {}  // Error?
}

Apa masalahnya?

a. Tidak ada, ini valid
b. Compile error ✅
c. Runtime error
d. Hanya warning

✅ Jawaban: b. Compile error
Penjelasan: Child tidak boleh melempar exception yang lebih “berat” dari parent (SQLException bukan turunan IOException).

⸻

🧵 Thread - Anonymous Runnable

Soal 5

public class ThreadDemo {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("Running"));
        t.start();
    }
}

Output?

a. Compile Error
b. Running ✅
c. Tidak mencetak apa-apa
d. Lambda tidak bisa dipakai di Thread

✅ Jawaban: b. Running
Penjelasan: Lambda valid karena Runnable adalah functional interface.

⸻

📦 Collections - HashSet

Soal 6

Set<String> set = new HashSet<>();
set.add("One");
set.add("Two");
set.add("One");
System.out.println(set.size());

Outputnya?

a. 3
b. 2 ✅
c. 1
d. Compile error

✅ Jawaban: b. 2
Penjelasan: HashSet tidak menerima duplikat, jadi “One” hanya disimpan sekali.

⸻

🧮 Lambda & Stream

Soal 7

List<String> list = Arrays.asList("a", "bb", "ccc");
long count = list.stream().filter(s -> s.length() > 1).count();
System.out.println(count);

Output?

a. 3
b. 2 ✅
c. 1
d. Compile error

✅ Jawaban: b. 2
Penjelasan: “bb” dan “ccc” panjangnya > 1.

⸻

🧨 Exception Handling

Soal 8

try {
    int x = 5 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: " + e);
}

Output?

a. Program crash
b. Error: java.lang.ArithmeticException: / by zero ✅
c. Compile error
d. Nothing printed

✅ Jawaban: b.
Penjelasan: Dibungkus try-catch, jadi akan tertangkap.

⸻

🌀 Abstract Class vs Interface

Soal 9

Apa pernyataan yang benar?

a. Interface bisa punya constructor
b. Abstract class boleh punya method lengkap ✅
c. Interface boleh punya method static yang tidak diimplementasikan
d. Abstract class tidak bisa memiliki field

✅ Jawaban: b
Penjelasan: Abstract class bisa punya method lengkap (non-abstract) & field.

⸻

🎭 Varargs dan Method Overload

Soal 10

void test(int... a) {
    System.out.println("Varargs");
}
void test(int a) {
    System.out.println("Single int");
}

test(5);

Apa output?

a. Varargs
b. Single int ✅
c. Compile error
d. Ambiguous

✅ Jawaban: b. Single int
Penjelasan: Java memilih method yang paling spesifik (int lebih spesifik dari int...).

⸻

Kalau kamu mau soal coding logic (misalnya buat output dari potongan kode tanpa pilihan ganda), aku juga bisa buatin. Mau dilanjut ke 10 soal lagi? Atau mau dikompilasi ke PDF buat latihan offline? 😎
