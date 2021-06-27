package com.onemount.Person;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonApplicationTests {
	
    ArrayList<Integer> VietNam = new ArrayList<>();
    ArrayList<Integer> China = new ArrayList<>();
    ArrayList<Integer> Japan = new ArrayList<>();
    ArrayList<Integer> Korea = new ArrayList<>();
    ArrayList<Integer> USA = new ArrayList<>();
    ArrayList<Integer> France = new ArrayList<>();
    ArrayList<Integer> Malaysia = new ArrayList<>();
    ArrayList<Person> people = new ArrayList<>(Array.personArrayList());

	@Test
	void contextLoads() {
	}
	@Test
    public void bai1_1() {
        System.out.println("Đếm số người theo từng quốc tịch in ra màn hình");
        Map<String, Integer> map = Array.personArrayList().stream().collect(
                Collectors.groupingBy(
                        Person::getNationality,
                        Collectors.collectingAndThen(
                                Collectors.mapping(Person::getAge, Collectors.toSet()),
                                Set::size)
                )
        );

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("- " + entry.getKey() + " : " + entry.getValue());
        }
    }

	@Test
    public void bai1_2() {
        System.out.println("Sắp xếp theo tên những người trên 25 tuổi rồi in ra màn hình");
        ArrayList<Person> listAge = new ArrayList<>();
        for (Person person : people) {
            if (person.getAge() > 25) {
                listAge.add(person);
            }
        }
        ArrayList<Person> sortAge = sortByAge(listAge);

        for (Person person : sortAge) {
            System.out.println(str + person.getName() + str + person.getNationality() + str + person.getAge());
        }
    }

    public ArrayList<Person> sortByAge(ArrayList<Person> personList) {

        Collections.sort(personList, new Comparator<Person>() {

            @Override
            public int compare(Person person1, Person person2) {
                return person1.getAge() - person2.getAge();
            }

        });
        return personList;
    }

	@Test
    public void bai1_3() {
        System.out.println("Tính trung bình tuổi của người theo từng quốc gia");
        for (Person person : people) {
            switch (person.getNationality()) {
                case "Vietnam":
                    intVietNam.add(person.getAge());
                    break;
                case "USA":
                    intUSA.add(person.getAge());
                    break;
                case "China":
                    intChina.add(person.getAge());
                    break;
                case "Korea":
                    intKorea.add(person.getAge());
                    break;
                case "Japan":
                    intJapan.add(person.getAge());
                    break;
                case "France":
                    intFrance.add(person.getAge());
                    break;
                case "Malaysia":
                    intMalaysia.add(person.getAge());
                    break;
            }
        }

        System.out.println("Vietnam: " + avg(VietNam));
        System.out.println("USA: " + avg(USA));
        System.out.println("Korea: " + avg(Korea));
        System.out.println("Japan: " + avg(Japan));
        System.out.println("France: " + avg(France));
        System.out.println("Malaysia: " + avg(Malaysia));
    }

    public int avg(ArrayList<Integer> arrayList) {
        int sum = 0;
        for (Integer item : arrayList) {
            sum = sum + item;
        }
        int avg = sum / arrayList.size();
        return avg;
    }

	@Test
    public void bai1_4() {
        System.out.println("In ra màn hình đánh giá tuổi mỗi người");
        String danhGiaTuoi = "";
        for (Person person : people) {

            if (person.getAge() < 20)
                danhGiaTuoi = "nổi loạn";
            else if (person.getAge() >= 20 && person.getAge() <= 30)
                danhGiaTuoi = "việc làm";
            else if (person.getAge() >= 31 && person.getAge() <= 40)
                danhGiaTuoi = "sự nghiệp";
            else
                danhGiaTuoi = "hưởng thụ";
            System.out.printf("- " person.getName() + " - " 
								+ person.getNationality() + " - " 
								+  person.getAge() + " - "
								+ danhGiaTuoi + "\n");
        }
	}

}
