## User Stories for Personal Expense Tracker:

| Story ID | User Story | Acceptance Criteria | Priority |
|----------|------------|---------------------|----------|
| US-001   | As a Primary User, I want to create a secure account so that my financial data is protected and private. | 1. User can sign up with email and password. 2. Passwords must be hashed via Bcrypt before storage. 3. Successful login redirects to dashboard.| High |
|US-002|As a Primary User, I want to log an expense with amount, date, and description so that I can track my daily spending.|1. Validation for numeric amount. 2. Date picker defaults to today. 3. Entry appears in history immediately.| High |
| US-003 | As a Primary User, I want to categorize my expenses so that I can see exactly where my money is going. | 1. Dropdown menu includes defaults (Food, Rent). 2. User can add/edit custom categories. 3. Selection is saved with the transaction.| High|
| US-004 | As a Primary User, I want to set a monthly budget limit for specific categories so that I avoid overspending. | 1. User can input a target limit for a category. 2. System displays "Budget vs. Actual" status. 3. Visual warning if limit is exceeded. | Medium|
| US-005 | As a Primary User, I want to search and filter past expenses so that I can find specific transaction details quickly.| 1. Search bar filters by keyword/description. 2. Date range filter works correctly. 3. Results update in real-time or < 1s. | Medium | 
| US- 006| As a Primary User, I want to view a visual chart of my spending so that I can analyze my financial habits at a glance. | 1. Pie/Bar chart shows distribution by category. 2. Chart updates immediately after adding an expense. 3. Tooltips show exact amounts on hover. |
| US-007| As a Financial Consultant, I want to export transaction data to CSV so that I can perform deeper analysis in external tools. | 1. "Export" button generates a .csv file. 2. File contains all fields (Date, Category, Amount). 3. Column headers match system field names. | Low |
| US-008| As a Primary User, I want to switch between different currencies so that I can track expenses while traveling or living abroad. | 1. Toggle available for ZAR, USD, EUR. 2. System applies conversion or updates symbols. 3. Currency preference is saved to user profile. | Low |
| US-009| As a Security Auditor, I want passwords hashed with Bcrypt so that user credentials are not stored in plain text. | 1. Verification that DB contains hashed strings, not raw text. 2. Login still functions via hash comparison. 3. Meets OWASP security standards. | High |
|US-010| As a System Admin, I want to manage system backups so that I can recover user data in case of a server failure. | 1. Automated backup runs daily. 2. Admin can trigger a manual snapshot. 3. Data integrity is verified after restoration. | High | 
| US-011| As a Product Owner, I want to review retention metrics so that I can understand how many users return to the app. | 1. Dashboard displays weekly active users (WAU). 2. Metrics show average session length. 3. Data is private to admin/owner roles. | Low |
| US-012 | As a Software Developer, I want the system containerized with Docker so that the application runs consistently across Windows and Linux. | 1. Dockerfile and docker-compose.yml present. 2. Container builds successfully on both OS. 3. Database and App link via internal network.| Medium|

## Product Backlog Creation:

| Story ID | User Story | Priority(MoScow) | Effort Estimate(1-5) | Dependencies |
|----------|------------|---------------------|----------|---------|
|US-001| Create secute account | Must-have| 5| None|
| US-002| log an expense | Must-have| 3| US-001|
| US-003| categorize expenses | Must-have | 2| US-002|
| US-OO4| set a monthly budget| Should-have| 4| US-003|
| US-005 | search and filter past expenses|Should-have| 2 | None |
| US-006 | view a visual spending chart | Should-have| 4| US-002|
| US-007| export data to CSV | Could-have | 2 | US-002 |
| US-008| switch between currencies | Could-have | 4 | None|
| US-009 | passwords hashed | Must-have | 3 | US-001 |
|US-010 | manage backups | Could-have | 4 | None|
|US-011| retention metrics | Won't-have | 5 | US-001 |
|US-12 | system containerized | Should-have | 3| None |
