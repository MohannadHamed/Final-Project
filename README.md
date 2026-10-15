# FINAL PROJECT - PROJECT ENGINE

## Runtime Terror Team Members

* **Mohannad Hamed** - responsible for Main method and making the variables/arrays and profile related methods
* **Malak Ahmed** - responsible for the search/update user, block/unblock account, view user details methods
* **Hla Hamdy** - responsible for favorite related methods (user panel) and statistics, view all users, show Transaction History (admin panel)
* **Mohamed Ibrahim** - responsible for the transaction related methods and making the variables/arrays related to the transactions

---

## Project Overview

QuickPay is a simple Java-based simulation of a digital wallet system (like InstaPay or Vodafone Cash) designed for managing virtual money.

Here is the general idea of how it works in plain terms:

### 1. Two Main Panels
* **User Panel:** Allows registered customers to log in, check their balance, transfer virtual money to other users via phone/email, track their transaction history, and manage a list of favorite contacts.
* **Admin Panel:** Gives an administrator high-level control to manage user accounts, search for users, view system-wide transaction logs, check overall statistics (like total transactions and active users), and block or unblock accounts.

### 2. Core Money Transfer Logic
* Every transfer requires verifying that the recipient exists, both accounts are active, and the sender has enough funds.
* When a transfer is sent, money is instantly deducted from the sender and added to the receiver.
* If anything goes wrong (e.g., insufficient balance or a blocked account), the transaction fails, and no money changes hands.

### 3. Purpose
It serves as an educational simulation—it doesn't use real money or real banking services—to demonstrate basic programming concepts in Java like loops, arrays, methods, and switch statements.

---

## How to use QuickPay

When you run the program you will get a choice between joining as an admin or as a user:

* **Clicking 1:** Logs you in as Admin.
  * Username: `Admin`
  * Password: `Adminpass123`

* **Clicking 2:** Logs you in as a User.
  Some logins you can use to test active accounts:
  * Email: `ahmed_mohamed@gmail.com` | Password: `Ahmed#2026!`
  * Email: `aly_osama@gmail.com` | Password: `Aly!Secret12`

  Logins to test blocked accounts (the system will refuse entry):
  * Email: `amr_youssef@gmail.com` | Password: `Amr_7890$`
  * Email: `joe_yasser@gmail.com` | Password: `JoePass@99`

* **Clicking 3:** Exit and terminate the program.

---

## ADMIN PANEL

After you log in as an admin, an admin panel will pop up with the following features:

1. **Show Statistics:** Shows the number of users, blocked accounts, active accounts, and number of transactions.
2. **Search User:** Gives info about a certain user.
3. **View All Users:** Gives info about all the users.
4. **Update User:** Lets you edit a certain user.
5. **View All Transactions:** Shows all transactions with details.
6. **Block Account:** Lets you block a certain user.
7. **Unblock Account:** Lets you activate a blocked user.
8. **View User Details:** Gives info about a certain user with more detail.
9. **Logout:** Logs you out of the admin panel and returns to starting menu.

---

## USER LOGIN / SIGNUP

After you choose to log in as a user, it gives you two options:

1. **Login:** Log in using a pre-registered email or a new account.
2. **Signup:** Enter required info (Email, Password, Phone number, Username) and the system will generate an ID for you.

---

## USER PANEL

The user panel gives the following options:

1. **Show Balance:** Shows the balance of the logged-in user.
2. **Transfer Money:** Transfer money to a different user via Phone Number.
3. **Transaction History:** Shows sent and received transactions (with who and amount).
4. **Show Favorites:** Shows the user's favorite contacts.
5. **Add Favorites:** Lets the user add a favorite user.
6. **Remove Favorites:** Lets the user remove a favorite user.
7. **Search Recipient:** Search for a user of your choice.
8. **View Profile:** Displays detailed info about the logged-in user.
9. **Update Profile:** Change profile info (Email, Username, Password, Phone Number).
10. **Logout:** Logs out of the user panel and returns to starting menu.

*Note: A user can have a maximum of 10 favorite contacts.*