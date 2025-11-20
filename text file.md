# 📱 MULTI‑POS App: គម្រោង UI/UX Design Document (ភាសាខ្មែរ)

**អេក្រង់ដែលគ្របដណ្តប់**៖ Launcher Screen, Welcome/Login Screen, Home Screen, All Items Screen, Cart Screen  
**Frameworks**៖ Kotlin (JVM 21+), Jetpack Compose, Firebase  
**Architecture**៖ Multi-panel, Role-based Access, Dependency Injection (Hilt/Koin)  

---

## 🎨 ១. ពណ៌សំខាន់ (Color Scheme)

| ធាតុ UI                | Color Code       | Context ប្រើប្រាស់                          |
|--------------------------|------------------|---------------------------------------------|
| **បៃតងសំខាន់**        | `#00C853`        | ផ្ទៃខាងក្រោយ, ប៊ូតុងសំខាន់ៗ (ទូទាត់, សងប្រាក់) |
| **ពណ៌ស**               | `#FFFFFF`        | អក្សរ, រូបតំណាង, វាលបញ្ចូល                  |
| **ពណ៌ខ្មៅងងឹត**       | `#212121`        | Overlay ខាងក្រោយ, Blur Login Screen          |
| **ពណ៌ប្រផេះ**          | `#BDBDBD`        | Placeholder, ជម្រើសបន្ទាប់                   |
| **ពណ៌ក្រហមសំខាន់**     | `#D50000`        | សកម្មភាពគ្រោះថ្នាក់ (ទិញផល)                 |
| **ពណ៌ប្រផេះស្រាល**     | `#F5F5F5`        | ផ្ទៃខាងក្រោយ, Container                      |
| **Font Khmer**          | Noto Sans Khmer  | Label និង Button ទាំងអស់                     |

---

## 🚀 ២. Launcher Screen

**គោលបំណង**៖ បង្ហាញម៉ាក MULTI‑POS, Loading លឿន, ផ្លាស់ប្តូរទៅ Login

- **ផ្ទៃខាងក្រោយ**៖ ពណ៌បៃតង `#00C853`  
- **Logo**៖ MULTI‑POS icon ពណ៌ស + បៃតង, Vector  
- **អក្សរ**៖ “MULTI‑POS” ពណ៌ស Bold  
- **Animation**៖ Fade‑in Logo ១.៥ វិនាទី  

**UX Behavior**  
- រយៈពេល៖ ២–៣ វិនាទី  
- ផ្លាស់ប្តូរ៖ ទៅ Welcome/Login Screen  
- Accessibility៖ ContentDescription, Contrast Checked  

---

## 👋 ៣. Welcome/Login Screen

**គោលបំណង**៖ ចូលប្រើប្រាស់ដោយសុវត្ថិភាព (Firebase Auth)

- **ផ្ទៃខាងក្រោយ**៖ រូប POS Blur + Overlay ខ្មៅ (`#212121`)  
- **ចំណងជើង**៖ “សូមស្វាគមន៍” + “ចូលគណនីរបស់អ្នក” (ពណ៌ស)  
- **វាលបញ្ចូល**៖ Email, Password (Rounded, White, Placeholder Gray)  
- **ប៊ូតុង**៖  
  - **ចូល** (Login): បៃតង `#00C853` + អក្សរស  
  - **ភ្លេចពាក្យសម្ងាត់?**: TextButton ប្រផេះ  
  - **បង្កើតគណនី**: អក្សរស Underline  

**UX Behavior**  
- Validation៖ Real‑time Input Check  
- Navigation៖ Compose Navigation Graph  
- Security៖ Firebase Auth + Role Routing  
- Accessibility៖ Keyboard‑aware, TalkBack  

---

## 🏠 ៤. Home Screen

**គោលបំណង**៖ សង្ខេបប្រចាំថ្ងៃ, សកម្មភាពលឿន

- **Header**៖ “ចំនួនសរុបត្រូវបង់” (ពណ៌ស Bold, ផ្ទៃបៃតង)  
- **កាលបរិច្ឆេទ**៖ `[ថ្ងៃ] [កាល] [ខែ] [ឆ្នាំ]` (ប្រផេះស្រាល)  
- **Chart Panel**៖ “[ក្រាហ្វិកលក់ប្រចាំថ្ងៃ]”  
- **ប៊ូតុងសកម្មភាព**៖  
  - **សងប្រាក់** (Green `#00C853`)  
  - **ទិញផល** (Red `#D50000`)  
  - **បិទម៉ាស៊ីន** (Black `#212121`)  

**UX Behavior**  
- Tap Expand, Swipe History  
- Role Visibility៖ Admin → Full Chart, Cashier → Summary  
- Accessibility៖ Label Khmer  

---

## 🛒 ៥. All Items Screen

**គោលបំណង**៖ Browse & Select Products

- **Search Bar**៖ White Background, Placeholder Gray  
- **Filter**៖ Horizontal Chips  
- **Item List**៖ Card (រូប, ឈ្មោះ, តម្លៃ)  
  - Example៖  
    - កែកប៊ឺរី `$12.00`  
    - ផ្លែប៉ោម `$8.00`  
    - តែខ្មៅ `$10.00`  
    - គ្រាប់ឈើកាស្យូ `$25.00`  
- **Checkout Button**៖ Label Khmer “ទូទាត់” (Green Full Width)  

**UX Behavior**  
- Real‑time Search (TextField + Flow)  
- Room Offline Cache  
- Navigation៖ Tap Item → Add to Cart  

---

## 🧾 ៦. Cart Screen

**គោលបំណង**៖ ពិនិត្យ និងបញ្ជាក់

- **Item Summary**៖  
  - កែកប៊ឺរី `$12.00`  
  - ផ្លែប៉ោម `$8.00`  
  - តែខ្មៅ `$12.00`  
- **Total**៖ Auto Sum, Bold  
- **Payment Options**៖ Cash, [QR](/public/images/qr.png) (Green Accent)  

**UX Behavior**  
- Firebase Sync Cart State  
- Role Routing៖ Manager → Discount Option  
- WorkManager Sync Background  

---

## 🔧 ៧. Technical Integration

- **Jetpack Compose**៖ UI Declarative  
- **Navigation Component**៖ NavHost  
- **WorkManager**៖ Sync Background  
- **Room**៖ Local Cache  

**Dependency Injection**  
- Hilt (ViewModel, Firebase, DAO)  
- Koin (Optional)  

**Concurrency**  
- Coroutines & Flow  
- JVM 21 Virtual Threads  

**Gradle 9.0.0**  
- Version Catalogs  
- Configuration Caching  
- Parallel Execution  

---

## 🔐 ៨. Firebase & Role-Based UX

| តួនាទី        | Access Panel                  | UI Adjustments                          |
|----------------|-------------------------------|-----------------------------------------|
| **Cashier**    | Items, Cart, Payment          | UI សាមញ្ញ, Label ភាសាខ្មែរ              |
| **Manager**    | Reports, Staff, Settings      | Tabbed Layout, Navigation ជ្រៅ           |
| **Admin**      | All Panels, User Management   | Full Access, Elevated Permissions        |

---
## 9. Generate a comprehensive, modern README file with real UI design for displaying and demo 

---
## 10. Generate .gitignore for the credential leaking to my github account, then Add, first commit, and push to it with the following:

```PS
git init
git add .
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/sisovin/multi-pos-app.git
git push -u origin main
```
