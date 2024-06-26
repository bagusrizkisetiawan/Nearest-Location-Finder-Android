# NearMe - Aplikasi Pencari Lokasi Terdekat

NearMe adalah aplikasi Android sederhana yang memungkinkan pengguna untuk mencari dan menampilkan lokasi terdekat dari daftar lokasi yang telah ditentukan sebelumnya. Aplikasi ini menggunakan Google Maps API untuk menampilkan peta dan menghitung jarak antara lokasi pengguna dan lokasi-lokasi terdekat.

## Fitur Utama

- Menampilkan peta dengan lokasi pengguna dan lokasi-lokasi terdekat.
- Menggunakan Google Maps untuk menampilkan detail lokasi dan rute.
- Menampilkan jarak dari lokasi pengguna ke lokasi-lokasi terdekat.
- Integrasi dengan RecyclerView untuk menampilkan daftar lokasi.

## Teknologi yang Digunakan

- **Android Studio**: IDE untuk pengembangan aplikasi Android.
- **Kotlin**: Bahasa pemrograman utama untuk pengembangan aplikasi.
- **Google Maps API**: Untuk menampilkan peta dan menghitung jarak antar lokasi.
- **RecyclerView**: Untuk menampilkan daftar lokasi dalam aplikasi.
- **Fused Location Provider API**: Untuk mendapatkan lokasi terkini pengguna.

## Instalasi dan Penggunaan

1. **Clone Repository**
  ```git
  git clone https://github.com/bagusrizkisetiawan/Nearest-Location-Finder-Android.git
  ```

2. **Buka dengan Android Studio**
- Buka Android Studio.
- Pilih "Open an existing Android Studio project".
- Arahkan ke direktori tempat Anda menyimpan repository ini dan pilih `build.gradle` di dalamnya.

3. **Konfigurasi API Key Google Maps**
- Dapatkan API Key untuk Google Maps dari [Google Cloud Console](https://console.cloud.google.com/).
- Ganti nilai `google_maps_api_key` di file `google_maps_api.xml` dengan API Key yang Anda dapatkan.

4. **Run Aplikasi**
- Hubungkan perangkat Android Anda atau gunakan emulator dalam Android Studio.
- Tekan tombol "Run" di Android Studio untuk menginstal dan menjalankan aplikasi di perangkat Anda.

## Kontribusi
Kontribusi Anda sangat diperkirakan! Untuk berkontribusi pada NearMe, silakan buka issue untuk saran atau masalah yang Anda temui, atau lakukan pull request untuk perbaikan atau penambahan fitur.

