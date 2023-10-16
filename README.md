## Class diagram:

``` mermaid
classDiagram
  class TravelAgency {
    - id: Long
    - name: String
    - contact: ContactInfo
    - address: Address
    - destinations: List<Destination>
    - clients: List<Client>
    - employees: List<Employee>
  }

  class ContactInfo {
    - id: Long
    - phone: String
    - email: String
  }

  class Address {
    - id: Long
    - street: String
    - city: String
    - state: String
    - zipCode: String
  }

  class Destination {
    - id: Long
    - name: String
    - country: String
    - description: String
    - pricePerPerson: Double
  }

  class Client {
    - id: Long
    - name: String
    - email: String
    - phone: String
    - nationality: String
  }

  class Employee {
    - id: Long
    - name: String
    - email: String
    - position: String
  }

  TravelAgency "1" -- "1" ContactInfo
  TravelAgency "1" -- "1" Address
  TravelAgency "1" -- "0..*" Destination
  TravelAgency "1" -- "0..*" Client
  TravelAgency "1" -- "0..*" Employee

``` 
