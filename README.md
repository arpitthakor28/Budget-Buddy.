# Budget-Buddy.
# Budget-Buddy.
<div align="center">

# 💸 Budget Buddy

### *Your Smart Personal Finance Companion*

[![Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com)
[![Java](https://img.shields.io/badge/Language-Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com)
[![Supabase](https://img.shields.io/badge/Backend-Supabase-3ECF8E?style=for-the-badge&logo=supabase&logoColor=white)](https://supabase.com)
[![SQLite](https://img.shields.io/badge/Local%20DB-SQLite-003B57?style=for-the-badge&logo=sqlite&logoColor=white)](https://sqlite.org)
[![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)](LICENSE)

</div>

---

## 📱 About Budget Buddy

**Budget Buddy** is a feature-rich **Android personal finance app** built to help users track their money, plan budgets, manage trips, and stay on top of loans — all within a premium, theme-aware UI.

> 💡 Built with clean architecture, local + cloud data sync via Supabase, and a visually stunning dark/light theme experience.

---

## ✨ Features

| Feature | Description |
|---|---|
| 📊 **Dashboard** | At-a-glance overview of income, expenses & recent activity |
| 💰 **Transactions** | Add, view, and manage all financial transactions |
| 🗂️ **Trip Management** | Track trip-wise expenses with detailed breakdowns |
| 📈 **Budget Planner** | Set category budgets and monitor spending vs. limits |
| 🏦 **Loan Tracker** | Manage loans given/received with status tracking |
| 🌗 **Dark & Light Mode** | Seamlessly switch between premium dark and light themes |
| 👤 **User Profiles** | Auth-based multi-user support with profile management |
| 🔒 **Multi-Identifier Login** | Sign in with email or phone number |
| 🔄 **Cloud Sync** | Supabase-powered backend for cross-device data sync |

---

## 🏗️ Architecture & Tech Stack

```
Budget Buddy
├── 📱 Android (Java)
│   ├── Activities (Dashboard, Budget, Trips, Loans, Profile...)
│   ├── Adapters (RecyclerView-based transaction & activity lists)
│   ├── Database (SQLite local DB + Room-like DAOs)
│   ├── Network (Supabase REST API integration)
│   ├── Workers (Background sync workers)
│   └── Utils (Theme helpers, formatters, validators)
│
└── ☁️ Backend (Supabase)
    ├── PostgreSQL Database
    ├── Row-Level Security (data isolation per user)
    └── Auth (Email + Phone login)
```

### 🛠️ Built With

- **Language:** Java (Android)
- **UI:** Custom XML layouts with Material Design components
- **Local Storage:** SQLite
- **Cloud Backend:** Supabase (PostgreSQL + Auth)
- **Build Tool:** Gradle
- **Theming:** Dynamic Dark/Light theme with `DayNight` support
- **Animations:** Custom Lottie-style splash & logo animations

---

## 📸 Screenshots

> *Coming soon — Dark & Light theme previews*

---

## 🚀 Getting Started

### Prerequisites

- Android Studio (Hedgehog or newer)
- Android SDK 26+
- A Supabase project (for cloud features)

### Setup

```bash
# 1. Clone the repository
git clone https://github.com/YOUR_USERNAME/Budget-Buddy.git

# 2. Open in Android Studio

# 3. Configure Supabase
# Add your Supabase URL and anon key to:
# app/src/main/res/values/supabase_config.xml

# 4. Run the app on an emulator or physical device
```

### Supabase Setup

Run the SQL script to initialize your database:

```bash
# Execute the provided schema
supabase_setup.sql
```

---

## 📁 Project Structure

```
app/src/main/java/com/moneyapp/
│
├── DashboardActivity.java       # Home screen with stats & activity feed
├── BudgetActivity.java          # Budget planning & category tracking
├── TripListActivity.java        # Trip overview & management
├── TripDetailActivity.java      # Per-trip expense tracking
├── LoanActivity.java            # Loan management
├── TransactionsActivity.java    # Full transaction history
├── LoginActivity.java           # Multi-identifier auth
├── RegisterActivity.java        # New user registration
├── ProfileActivity.java         # User profile & settings
├── SettingsActivity.java        # App settings & theme toggle
│
├── adapter/                     # RecyclerView adapters
├── database/                    # Local SQLite DAOs & helpers
├── model/                       # Data models (Transaction, Trip, Loan...)
├── network/                     # Supabase API clients
├── service/                     # Background services
├── util/ & utils/               # Helper utilities
└── worker/                      # WorkManager background tasks
```

---

## 🎨 Design Highlights

- **Glassmorphism UI** – frosted glass cards, gradient backgrounds
- **Premium Dark Theme** – deep charcoal/navy palette with vivid accents
- **Light Theme** – clean whites with matching gradient extrapolation from dark theme
- **Animated Splash Screen** – custom logo animation with physics-based motion
- **Neon Accent Avatars** – dark background with neon-blue profile avatar styling

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

1. Fork the repo
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

## 📜 License

This project is licensed under the **MIT License** — see the [LICENSE](LICENSE) file for details.

---

<div align="center">

Made with ❤️ and ☕ | **Budget Buddy** — *Spend Smart. Save More.*

⭐ **Star this repo** if you found it helpful!

</div>
