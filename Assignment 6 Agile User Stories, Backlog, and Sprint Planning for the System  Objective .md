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

## Sprint Backlog Table
Contribution to MVP: This sprint focuses on the two most critical pillars of the Minimum Viable Product: User Authentication and Expense Logging. By completing these, we ensure the app is secure (Bcrypt) and functional (users can record data), providing the baseline value required for the first release.

| Task ID | Task description | User Story Link| Estimated Hours| Status |
|----------|------------|---------------------|----------|---------|
|T-001| Create database schema for User and Expense tables| US-001, US-002 | 4| To Do|
| T-002 | Develop Backend API for User Registration | US-001 | 8 | In Progress |
|T-003 | Integrate Bcrypt library for password hashing | US-009 | 3 |To Do |
| T-004 | Design Responsive Login/Sign-up UI | US-001 | 6 | To Do |
|T-005 | Build "Add Expense" Form with validation | US-002 | 5| To Do |
| T-006 | Develop API endpoint to POST new expenses | US-002 | 6| To Do|

## Reflection: The Internal Struggle of Being My Own Stakeholder

The Challenge of Prioritization
The biggest challenge in this project was playing two roles at once. As the Stakeholder, I wanted my app to have every possible feature, like currency converters and fancy charts. But as the Developer who actually has to build it, I felt a lot of resistance because I knew how much work that would take.

Using the MoSCoW method helped me settle this "internal argument." I had to be honest and move things I wanted (like currency switching) into the "Could-have" category so I could focus on what the app actually needs to work (like secure login and logging expenses). It was hard to admit that some "cool" features weren't actually "Must-haves" for a passing grade.

Estimation vs. Reality
When I started Effort Estimation, I was too optimistic. I thought adding Bcrypt hashing would be a "1-point" task (very easy). However, when I sat down to actually plan the database and the logic, the "developer" in me started feeling stressed. I realized that security is never that simple. I had to increase my estimates from 1 to 3 points. This shows how easy it is to underestimate technical work when you are just looking at a "bubble" on a Use Case diagram.

Dealing with Internal Resistance
There was a lot of internal resistance when it came to Non-Functional Requirements, like using Docker. Part of me felt like it was an unnecessary extra step that made the work harder. However, as a student who wants a professional portfolio, I knew it was important for "Maintainability."

Conclusion
Even though I am the only person working on this, using GitHub Issues and Projects helped me stay organized. When I saw a "Must-have" task sitting in the "To Do" column, it forced me to stop procrastinating and start working. This assignment taught me that Agile isn't just for big companies; it’s a way to manage your own time and stop "scope creep" from making a project impossible to finish.
