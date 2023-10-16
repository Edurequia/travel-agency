## Class diagram:

``` mermaid
classDiagram
  class TravelAgency {
    - name: String
    - contact: ContactInfo
    - address: Address
    - destinations: List<Destination>
    - packages: List<Package>
    - clients: List<Client>
    - employees: List<Employee>
  }

  class ContactInfo {
    - phone: String
    - email: String
  }

  class Address {
    - street: String
    - city: String
    - state: String
    - zipCode: String
  }

  class Destination {
    - name: String
    - country: String
    - description: String
    - pricePerPerson: Double
  }

  class Package {
    - name: String
    - destination: String
    - duration: Integer
    - totalPrice: Double
    - departureDate: String
    - returnDate: String
  }

  class Client {
    - name: String
    - email: String
    - phone: String
    - nationality: String
  }

  class Employee {
    - name: String
    - email: String
    - position: String
  }

  TravelAgency "1" -- "1" ContactInfo
  TravelAgency "1" -- "1" Address
  TravelAgency "1" -- "0..*" Destination
  TravelAgency "1" -- "0..*" Package
  TravelAgency "1" -- "0..*" Client
  TravelAgency "1" -- "0..*" Employee

``` 
