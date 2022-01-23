package com.allinonejava;


import java.util.ArrayList;
import java.util.List;

public class Scratch {

    enum Color { BLUE, BLACK, YELLOW };
    enum GenderType { Man, Woman, Lesbian, Gay, BiSexual, Transgender }; // enum 타입의 타입명은.. xxxType이나 xxxList로 끝나는게 좋음
    enum BuildType { Local, Dev, Prod };

    BuildType currentBuildType;
    public static void main(String[] args) {
        // IL intermediate language

        // 모든 프로그램은 main 함수를 가지고 있고, entry point라고 함
        // 프로그램을 구동 시키는 역할만 함... 이라고 하기엔 다른 것도 하긴 함;;
        // 스크립트 언어는 일부 main이 없을 수도 있음

        // 값타입이냐 참조타입이냐로 구분 할 수도 있고
        // 내장타입이냐 사용자정의타입이냐로도 구분할 수 있다
        // 단순타입, 복합타입

        // 값타입 : int, float, double, long, bool, char, struct, enum
        // 참조타입 : class, string
        // 내장타입(프로그램언어가 제공하는 타입) : int, float, double, long, bool, char, string
        // 사용자정의타입(사용자가 만들어서 쓰는 타입 XXXXComponent, XXXStore, XXXController, XXXService, XXXMapper)
        //   : class, struct(요즘안써...), enum(열거형.. 이건 자주 써)
        // 단순타입(변수하나에 값하나가 assign되는 형태) : int, float, ...., enum
        // 복합타입 : class, struct....

        // 타입은.. 특히 값타입이나 내장타입은 언어나 환경마다 틀려?? 그 크기가 틀려... int는 java/.net에서 32bit => 4바이트

        // 열거형(enum)사용 : 여러개의 대상 중 하나를 지정하기 위함
        Color myFavoriteColor = Color.BLACK;
        System.out.println(myFavoriteColor);

        Scratch sc = new Scratch();
        sc.printGender(GenderType.Lesbian);

        // 함수 : 어떤 단위 처리를 위해 기능을 묶어 놓음 ex) addText, removeLastCharacter, getCurrentTime, getName, getSomeStatus
        // Controller -> Service -> mapper -> sql에서 해당 함수 찾아서 sp 실행... => 이것도 사실 한 함수 안에서 처리 가능
        // 기능적으로 하는 일이 틀리기 때문에 나눠서 구현함, 재사용될 수 있는 기능들은 함수로 분리
        int i = 5;
        int j = 10;
        int k = i + j;
        System.out.println(k);
        System.out.println(sc.addValues(i, j));

        System.out.println(sc.IsGreaterThan(i, j));
        System.out.println(sc.IsGreaterThan(20, 15));
        boolean bTemp = sc.IsGreaterThan(54, 12); // 결과 값을 변수에 넣어서도 사용

        // IF ================================================================
        // if( ??? ) ==> ??? 에 뭐가 들어가냐
        // int i = 5; ==> i는 int고, 5도 int
        // boolean bTemp = sc.IsGreaterThan(54, 12); ==> bTemp는 bool, sc.IsGreaterThan(54, 12)는??
        // 하고 있는 액션은 Scratch 클래스의 인스턴스 sc의 멤버인 IsGreaterThan을 호출하고 있지만, 그 결과는?? bool 타입이잖아..
        // 뭔가가 실행됐을 때, 어떤 타입으로 evaluate 되는지를 항상 알아야 댐...
        // ... 호출하고 있지만, 그 결과는 결국 bool 타입으로 evaluate된다
        // if( ??? )  ==> ???에 뭐가 들어가야 하냐?? bool타입으로 evaluate되는 값이 들어가야 함
        // if(bTemp) 인 경우에는 bTemp는 이미 bool이니까 evalute하지 않아도 bool 타입이고
        // if(sc.IsGreaterThan(1, 2)) ==> "sc.IsGreaterThan(1, 2)" 이거는 결국 bool을 반환하기 때문에 evalute하면
        // bool 타입이니까 if(sc.IsGreaterThan(1, 2)) 이것도 가능한거고
        // if( ??? ) 과 같이 사용하는 예제가..
        // 1. if(bTemp) 와 같이 그냥 bool 값
        // 2. if(sc.IsGreaterThan(1, 2)) 와 같이 함수의 반환 값
        // 3. if( i > j ) 과 같이 직접적인 값 비교
        // 이 3개 밖에 없어!!! 대신... 여러 bool 값이 들어갈 수 있겠지
        // 4. if( i > j && bTemp ) 첫번째 식 i > j 라는걸 우선 evalute해서 true고, bTemp가 true여야 실행
        // 5. if( i > j || sc.IsGreaterThan(1, 2)) 앞 뒤 둘중 하나만 true면 true

        // if-else, if-else if, if-else if-else, if-else if-else if... -else
        // 0~30 : 못했어요, 31~80 : 그냥저냥, 81~100 : 잘했어요
        int score = 55;
//        if(score < 31) {
//            System.out.println("못했어요");
//        } else if(score < 81) {
//            System.out.println("그냥저냥");
//        } else if (score <= 100) {
//            System.out.println("잘했어요");
//        }
        if (score <= 100) {
            System.out.println("잘했어요");
        } else if(score < 81) {
            System.out.println("그냥저냥");
        } else if(score < 31) {
            System.out.println("못했어요");
        }
        // if-else if, if-else if-else, if-else if-else if... -else 이런 경우에는
        // 위에서 먼저 조건에 걸려 버리면, 뒤에 있는 조건은 evaluate하지 않고 그냥 if가 종료됨!!
        // 그러니 if/if else/else를 혼용해서 쓰는 경우에는 위에서 걸려서 밑으로 안 떨어지는지를 반드시 확인해야 함!!
        // 그리고 if/if else가 3개가 넘어가는 경우에는.. switch-case문을 고려할 것!! switch-case는 근데.. if랑은 틀려
        // 뭐가 틀려?? 이건 뒤에서...

        // 배열 ... 변수 바구니...
        int[] intArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        String[] stringArray = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        Person p1 = new Person();
        p1.id = 1001;
        p1.name = "김예린";
        p1.age = 28;
        p1.gender = 'F';
        p1.email = "yerin.kim@teongteong.com";
        p1.address = "남양주";
        p1.memo = "오늘상태안좋음";

        Person p2 = new Person();
        p2.id = 1002;
        p2.name = "채린쓰";
        p1.age = 29;
        p1.gender = 'F';
        p1.email = "chaerinth@teongteong.com";
        p1.address = "구리";
        p1.memo = "내일안좋을예정";

        Person p3 = new Person();
        p3.id = 1003;
        p3.name = "짜장쓰";
        p3.age = 7;
        p3.gender = 'F';
        p3.email = "zzajangth@teongteong.com";
        p3.address = "다산";
        p3.memo = "";

        Person p4 = new Person();
        p4.id = 1004;
        p4.name = "텅순쓰";
        p4.age = 18;
        p4.gender = 'M';
        p4.email = "teongsunth@teongteong.com";
        p4.address = "남양주";
        p4.memo = "";

        // 컬렉션이나 배열에 담아서 하나로!! return 해야지..
        // 위 4개를 list(ArrayList)에 담아보자
        // List stack = new Stack(); // public class Stack implement List...
        // List vector = new Vector(); // public class Vector imple.. List
        // List arrayList = new ArrayList();
        // 다 중요하지만 우린 ArrayList만 알자!!

        int q = 1; // int 타입 -> class int { }; -> 실제로는 public class Integer { };
        Object o = q; // Object 클래스는 모든 클래스의 부모이므로 int를 Object에 담을 수 있다.
        o = 5;

        String s = "yerin"; // public class String { };
        Object o2 = s; // Object 클래스는 모든 클래스의 부모이므로 string도 Object에 담을 수 있다.
        o2 = "chaerin";

        Person p = new Person(); // public class Person { };
        Object o3 = (Object)p; // Person 클래스도 Object의 자식 클래스 이므로 당연히 담을 수 있다...
        o3 = new Person();

        List myList = new ArrayList();
        myList.add(q); // int도 object니까 add가 가능하고
        myList.add(s); // string도 object니 add가 가능하고
        myList.add(p); // 내가만든 person클래스도 object니 add가 당연히 가능하고..

        // int[] intArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // 이 배열의 멤버에 액세스 하려면... intArray[index] 인덱스트는 위 경우 0부터 8까지 있겠지;;
        // List 멤버에 액세스 하려면... 함수로 액세스를 해야 함
        System.out.println(myList.get(0));
        System.out.println(myList.get(1));
        System.out.println(myList.get(2));

        // 객체를 리스트에서 제거하는 방법
        //myList.remove(s);
        //System.out.println(myList.get(0));
        //System.out.println(myList.get(1));
        //System.out.println(myList.get(2)); // 여기서는 out of index 에러 발생

        // 인덱스로 리스트에서 제거
//        myList.remove(0); // 첫번째 인덱스에 있는 놈 제거..
//        System.out.println(myList.get(0));
//        System.out.println(myList.get(1));
//        System.out.println(myList.get(2)); // 여기서는 out of index 에러 발생

        // myList에는 add(Object) 때문에... 뭐든지 다 넣을 수 있어...
        // 그 안에 그러면.. 여러 개의 타입이 다 섞여서 List안에 다 들어가게되지... ??

        //int w = myList.get(0); // 타입만 놓고 보면 myList.get(0)는 Object지만...
        // Object가 되기 전에.. 무슨 타입이었어?? int였잖어..  윗줄하고 이 줄은 무시!!
        // Person pp = myList.get(2); 타입만 놓고보면 myList.get(2)
        Person pp = (Person)myList.get(2);
        System.out.println(pp);







    }

    private void printGender(GenderType ge) {
        System.out.println(ge);
    }

    private int addValues(int i, int j) {
        return i + j;
    }

    // 파라미터를 두개 받아, 크기를 비교하는 함수인데..
    private Boolean IsGreaterThan(int i, int j) {
        // 식을 간소화 해보자
        // #1번 방식
//        boolean result;
//
//        if(i > j) {
//            result = true;
//        } else {
//            result = false;
//        }
//
//        return result;

        // #2번 방식
//        if( i > j ) {
//            return true;
//        } else {
//            return false;
//        }
        // if( ??? ) ==> ???에 뭐가 들어간다고?? bool으로 evalute되는 값이든 식이든 들어가면 된다고 했잖아!!!!!!!!!!!!!
        // 쉽게 얘기하면 if ( ??? ) 저 ???는 그냥 bool이야!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // if ( i > j ) 에서   "i > j"만 봐바.. 이거 뭐야.. 이거 타입이 bool이야

        // #3번
        return i > j; // i > j는 값에 따라 true아니면 false임...

//        if(.............
//        || ...........
//        (.......... && ..........)
//        || ..........)
        // 조건 여러개가 물려 있어도.. 결국엔 true아니면 false!!!!!!!
    }

    public class SearchModel {
//        private String cd;
//        private String cdNm;

        // 다른 클래스에서 꺼내 쓸때..
//        public String getCd() {
//            return this.cd;
//        }
        // 이런 식으로 getter랑 setter를 만들어서 클래스 외부에서 저 private 멤버들에게 접근했...
        // 그래서 저걸 편하게 해주는게 lombok -> 라이브러리(패키지).. 이 안에 뭐 있어?? 클래스들있어..
        // 근데 그걸 우리가 어떻게 갖다써??? 어노테이션.. 어노테이션이 뭐라고??
        // 어노테이션을 적용하는 대상 클래스가 가지고 있지 않은 기능을 추가 시켜주는 기능...

        public String cd;
        public String cdNm;
    }
}



