# VeloraGames v15

## Isi
- APK Android project di `app/`
- Frontend `index.html`
- Backend Cloudflare Worker di `worker/`
- D1 schema di `worker/schema.sql`

## Backend
Database yang dipakai bernama `velora`.

### Deploy tanpa hard-code D1 ID
Gunakan:

```bash
bash worker/deploy.sh
```

Script akan mencari D1 bernama `velora` otomatis, lalu membuat konfigurasi deploy sementara dengan database ID yang benar.

Untuk Cloudflare Workers Builds, set **Deploy command** menjadi:

```text
bash worker/deploy.sh
```

Pastikan environment/secret berikut tersedia:
- `CLOUDFLARE_API_TOKEN`
- `CLOUDFLARE_ACCOUNT_ID`

Token membutuhkan izin Workers Scripts Edit dan D1 Edit.

## Database
Jalankan `worker/schema.sql` pada D1 `velora` sebelum memakai API.

## Fitur
- Buyer / Seller / Admin
- Seller Rp15.000 / 15 hari
- Seller aktif dapat posting langsung tanpa approval
- Admin dapat posting langsung
- QRIS seller dan buyer
- Pesanan dan verifikasi pembayaran
- Chat / conversations / messages
- Saldo seller dan withdrawal
- Remember session 30 hari di backend


## GitHub Actions
The Android build uses the included `app/google-services.json` for Firebase/FCM. The Firebase package is `com.veloragames.app`. Run the `Build VeloraGames APK` workflow from GitHub Actions.
