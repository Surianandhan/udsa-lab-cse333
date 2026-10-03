# Usability Design of Software Applications Lab (CSE333)

This repository contains Usability Design of Software Applications (UDSA) lab programs implemented as Android applications in Java and XML as part of the CSE333 course.

## Overview

The programs demonstrate Android user interface design and interaction, including XML layouts, event handling, menus and lists, input forms, navigation between activities using Intents, and local data storage with SQLite.

## Topics Covered

### User Interface Basics
- Displaying text with TextView and LinearLayout
- Changing background color and image on button click
- Cycling through multiple images with a button

### Event Handling
- Button click listeners
- Counting ENTER key presses with key listeners

### Menus, Lists and Layouts
- Options menu (Home, Canteen Info, Exit)
- ListView with ArrayAdapter
- Switching between multiple layouts

### Forms and Input Controls
- Bank account registration form (EditText, Spinner, AlertDialog)
- User input form (EditText, RadioGroup, TextView output)
- Input validation with Toast messages

### Activities and Intents
- Navigating between activities using explicit Intents
- Passing data with putExtra() / getStringExtra()
- Sending SMS through the default messaging app (ACTION_SENDTO)

### Database
- SQLite employee management (Add, View, Modify, Delete, View All)

## Project Structure

```
udsa-lab-cse333/
│
├── CSE333/
│   ├── 01_HelloWorld/
│   ├── 02_BackgroundColorImage/
│   ├── 03_EnterKeyCounter/
│   ├── 04_ImageChangeOnClick/
│   ├── 05_MenusListsLayouts/
│   ├── 06_SQLiteEmployeeDB/
│   ├── 07_BankAccountRegistration/
│   ├── 08_UserInputForm/
│   ├── 09_IntentDataPassing/
│   └── 10_SendSMS/
│
└── README.md
```

Each folder contains the layout file(s) (`.xml`) and activity file(s) (`.java`) for one experiment.

## How to Run

1. Open Android Studio and create a new project using the **Empty Views Activity** template (language: Java).
2. Copy the files from an experiment folder into the project:
   - `.java` files → `app/src/main/java/<your package>/`
   - Layout `.xml` files → `app/src/main/res/layout/`
   - `mymenu.xml` (Experiment 05) → `app/src/main/res/menu/`
   - `AndroidManifest.xml` (Experiment 09) → `app/src/main/` (or add the `SecondActivity` entry to your existing manifest)
3. Change the `package` line at the top of each `.java` file to match your project's package name.
4. Build and run on an emulator or Android device.

> Note: Experiment 04 needs five images named `img1` to `img5` in `res/drawable/`. Experiment 10 should be run on a real device with a messaging app installed.

## Purpose

- Understand Android UI design using XML layouts
- Handle user interaction through events and listeners
- Build multi-screen applications using Intents
- Practice form design, validation and data storage

## Notes

The code was extracted from the lab records and corrected so it builds on current Android Studio versions:
- `android.support.*` imports updated to AndroidX
- Experiment 03: ENTER is also counted when pressed on an on-screen keyboard
- Experiment 05: `switch` on menu IDs replaced with `if-else` (resource IDs are not constants in AGP 8+)
- Experiment 06: SQL queries use `?` placeholders, so input containing quotes no longer crashes the app, and cursors are closed
- Experiment 09: `AndroidManifest.xml` added to register `SecondActivity`

## Future Improvements

- Add screenshots of outputs for each experiment
- Provide complete Android Studio project folders
- Add comments explaining each program

## Author

Surianandhan Sridhar
