package com.xpinjection.java8.misused.optional;

import com.xpinjection.java8.misused.Annotations.Bad;
import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

public class HundredAndOneApproach {
    public static void main(String[] args) {
        HundredAndOneApproach approach = new HundredAndOneApproach();
        Person person = approach.new Person();
        Optional<Car> car = ofNullable(person).flatMap(Person::getCar);
        Optional<Insurance> insurance = car.flatMap(Car::getInsurance);
        Optional<String> name = insurance.map(Insurance::getName);
        System.out.println(name);// Optional.empty
        String unknown = insurance.map(Insurance::getName).orElse("Unknown");
//        .orElse -> Return the value if present, otherwise return {@code other}.
        System.out.println(unknown); // "Unknown"
    }
    @Ugly
    class SameOldImperativeStyle {
        public String getPersonCarInsuranceName(Person person) {
            String name = "Unknown";
            if (ofNullable(person).isPresent()) {
                if (person.getCar().isPresent()) {
                    if (person.getCar().get().getInsurance().isPresent()) {
                        name = person.getCar().get().getInsurance().get().getName();
                    }
                }
            }
            return name;
        }
    }

    @Ugly
    class UsingIfPresentInSameImperativeWayWithDirtyHack {
        public String getPersonCarInsuranceName(Person person) {
            final StringBuilder builder = new StringBuilder();
            ofNullable(person).ifPresent(
                    p -> p.getCar().ifPresent(
                            c -> c.getInsurance().ifPresent(
                                    i -> builder.append(i.getName())
                            )
                    )
            );
            return builder.toString();
        }
    }

    @Bad
    class UsingMapWithUncheckedGet {
        public String getPersonCarInsuranceName(Person person) {
            return ofNullable(person)
                    .map(Person::getCar)
                    .map(car -> car.get().getInsurance())
                    .map(insurance -> insurance.get().getName())
                    .orElse("Unknown");
        }
    }

    @Ugly
    class UsingMapWithOrElseEmptyObjectToFixUncheckedGet {
        public String getPersonCarInsuranceName(Person person) {
            return ofNullable(person)
                    .map(Person::getCar)
                    .map(car -> car.orElseGet(Car::new).getInsurance())
                    .map(insurance -> insurance.orElseGet(Insurance::new).getName())
                    .orElse("Unknown");
        }
    }

    @Good
    class UsingFlatMap {
        public String getCarInsuranceNameFromPersonUsingFlatMap(Person person) {
            return ofNullable(person)
                    .flatMap(Person::getCar) // similar to {@link #map(Function)},
//                   but the provided mapper is one whose result is already an {@code Optional}
                    .flatMap(Car::getInsurance)
                    .map(Insurance::getName)
                    .orElse("Unknown");
        }
    }

    class Person {
        public Optional<Car> getCar() {
            return empty(); //stub
        }
    }

    class Car {
        public Optional<Insurance> getInsurance() {
            return empty(); //stub
        }
    }

    class Insurance {
        public String getName() {
            return ""; //stub
        }
    }
}
