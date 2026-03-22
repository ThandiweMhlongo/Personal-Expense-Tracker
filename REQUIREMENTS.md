## System Requirements Document:

## Functional Requirements
1. The system shall allow users to create an account with a secure username and password.
2. The system shall allow users to log an expense with an amount, date, and description.
3. The system shall provide a dropdown to categorize expenses (e.g., Food, Rent, Transport) Acceptance Criteria: Categories must be editable by the user.
4. The system shall display a monthly summary of total spending.
5. The system shall allow users to set a monthly budget limit for specific categories.
6. The system shall provide a search bar to filter past expenses by keyword or date.
7. The system shall display a visual chart (pie/bar) of spending distribution. Acceptance Criteria: Charts must update immediately after a new entry is saved.
8. The system shall allow users to edit or delete previously entered transactions.
9. The system shall support exporting all transaction data to a CSV format.
10. The system shall allow users to switch between different currencies (e.g., ZAR, USD, EUR).

## Non-Functional Requirements:
Usability: The interface shall be mobile-responsive and require no more than 3 clicks to reach the "Add Expense" screen.

Deployability: The system shall be containerized using Docker to run on both Windows and Linux environments.

Maintainability: The backend code shall follow SOLID principles and include docstrings for all primary functions.

Scalability: The database schema shall support up to 10,000 transaction records per user without performance degradation.

Security: All user passwords shall be hashed using Bcrypt before storage in the database.

Security: The system shall automatically log out the user after 15 minutes of inactivity.

Performance: The dashboard and spending charts shall load in under 1.5 seconds.

Performance: API response times for saving an expense shall not exceed 500ms.
