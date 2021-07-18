package org.example.chapter02;

@FunctionalInterface // 함수형 인터페이스임을 보장한다. Single Abstract Method(SAM) 보장
interface Function3<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);
}

public class MyFunctionalInterface {
    public static void main(String[] args) {
        println(1, 2, 3, (i1, i2, i3) -> String.valueOf(i1 + i2 + i3));
        println("Area is ", 12, 20, (message, length, width) -> message + (length * width));
        println(1L, "Jiwon", "test@email.com",
                (id, name, email) -> "User info: ID=" + id + ", name=" + name + ", email=" + email);
    }

    private static <T1, T2, T3> void println(T1 t1, T2 t2, T3 t3, Function3<T1, T2, T3, String> function) {
        System.out.println(function.apply(t1, t2, t3));
    }
}