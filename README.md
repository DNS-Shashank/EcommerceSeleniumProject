**OAuth API Testing Project**


**Overview**
This project demonstrates comprehensive API testing using RestAssured framework with OAuth authentication and e-commerce operations. It includes multiple test scenarios covering authentication, data validation, and CRUD operations.

**Key Features**
1. OAuth Authentication Testing (oAuthTest.java)
Client Credentials Flow: Implements OAuth 2.0 client credentials grant type

**Token Management:** Extracts and utilizes access tokens for API calls

**Data Validation:** Validates course data using POJO deserialization

**Assertion Testing:** Compares expected vs actual course titles using TestNG assertions

**2. E-Commerce API Testing (ECommerceAPITest.java)**
**Complete E-commerce Flow:** Login → Add Product → Create Order → Delete Product
**
Authentication:** User login with email/password credentials

**Product Management:** Add products with image upload using multipart form data

**Order Processing:** Create orders with product details and country information

**Cleanup Operations:** Delete products after testing

**3. POJO Classes
LoginRequest/LoginResponse: **Handle authentication data

**OrderDetail/orderRequest:** Manage order information

**Course-related POJOs:** Structure course and API data for validation

**Technical Stack
RestAssured:** API testing framework

**TestNG:** Assertion and testing framework

**Jackson:** JSON serialization/deserialization

**Maven: **Dependency management

**Test Scenarios
OAuth Token Generation:** Validates client credentials authentication

**Protected Resource Access:** Uses tokens to access secured endpoints

**Data Integrity: **Verifies API response data matches expected values
**
File Upload:** Tests multipart form data with image uploads

**End-to-End Workflow: **Complete e-commerce transaction flow

**Project Structure
src/main/java/
├── ExternalReports/OAuth/     # Test classes
└── POJO/                      # Data models**

**Copy**
This project serves as a comprehensive example of API testing best practices including authentication, data validation, and complete workflow testing.
