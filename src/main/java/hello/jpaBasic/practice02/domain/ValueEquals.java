package hello.jpaBasic.practice02.domain;

public class ValueEquals {
    public static void main(String[] args) {
        Address address1 = new Address("city","street","10000");
        Address address2 = new Address("city","street","10000");

        //값 타입을 재정의하지 않았을 때
        //System.out.println("address1 == address2 = " + (address1 == address2)); 참조 다르다. false
        //System.out.println("address1.equals(address2) = " + address1.equals(address2));false

        //값 타입을 재정의했을 때 -> 모든 속성을 재정의해서 동등성 비교를 해야한다.
        System.out.println("address1 == address2 = " + (address1 == address2)); //false
        System.out.println("address1.equals(address2) = " + address1.equals(address2));//true
    }
}
