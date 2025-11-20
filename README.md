# 📱 MULTI-POS App

![Status](https://img.shields.io/badge/Status-Development-green) ![Kotlin](https://img.shields.io/badge/Kotlin-1.9.20-purple) ![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Enabled-blue) ![Firebase](https://img.shields.io/badge/Firebase-Enabled-orange)

**MULTI-POS** is a modern, secure, and efficient Point of Sale (POS) application designed for Android. Built with **Kotlin** and **Jetpack Compose**, it features a robust multi-panel architecture with role-based access control, ensuring a seamless experience for Cashiers, Managers, and Admins.

---

## 🎨 UI/UX Design

The application follows a clean and intuitive design language with a focus on usability and accessibility.

### Color Scheme

| Element | Color | Hex | Usage |
| :--- | :--- | :--- | :--- |
| **Primary** | ![#00C853](https://via.placeholder.com/15/00C853/000000?text=+) Green | `#00C853` | Backgrounds, Main Buttons (Pay, Refund) |
| **Secondary** | ![#FFFFFF](https://via.placeholder.com/15/FFFFFF/000000?text=+) White | `#FFFFFF` | Text, Icons, Input Fields |
| **Accent** | ![#D50000](https://via.placeholder.com/15/D50000/000000?text=+) Red | `#D50000` | Dangerous Actions (Buy Product) |
| **Dark** | ![#212121](https://via.placeholder.com/15/212121/000000?text=+) Black | `#212121` | Overlays, Blur Effects |

### Screens

#### 🚀 Launcher Screen

- **Fast Loading**: Optimized startup with a fade-in logo animation.
- **Branding**: Iconic Green background with bold White typography.

#### 👋 Welcome/Login Screen

- **Secure Access**: Integrated with Firebase Auth.
- **Modern UI**: Blurred background with a dark overlay for focus.
- **Accessibility**: High contrast and clear input fields.

#### 🏠 Home Screen

- **Dashboard**: Daily summary and quick actions.
- **Real-time Data**: Live sales charts and total to pay.
- **Role-Based**: Different views for Admin (Full Chart) vs Cashier (Summary).

#### 🛒 All Items Screen

- **Product Browser**: Grid view of products with images and prices.
- **Search & Filter**: Real-time search and category chips.
- **Offline Capable**: Room database caching for offline access.

#### 🧾 Cart Screen

- **Checkout**: Detailed item summary and auto-calculated totals.
- **Payment Options**: Cash and QR Code payments (ABA Pay).

---

## 🛠 Tech Stack

- **Language**: Kotlin (JVM 21+)
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM, Multi-panel
- **Dependency Injection**: Hilt
- **Concurrency**: Coroutines & Flow
- **Local Storage**: Room Database
- **Backend**: Firebase (Auth, Firestore)
- **Background Tasks**: WorkManager

---

## 🚀 Getting Started

### Prerequisites

- Android Studio Hedgehog or later
- JDK 17+

### Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/sisovin/multi-pos-app.git
   cd multi-pos-app
   ```

2. **Open in Android Studio**
   - Open Android Studio and select "Open an existing Android Studio project".
   - Navigate to the cloned directory.

3. **Build and Run**
   - Sync Gradle files.
   - Select an emulator or connected device.
   - Click the **Run** button.

---

## 🤝 Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

---

## 📄 License

This project is licensed under the MIT License.

---

*Developed by Sisovin Chieng*
