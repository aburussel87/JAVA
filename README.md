# How to Add an Existing Folder to a New GitHub Repository

This guide explains how to push a local folder to a new GitHub repository.

## ✅ Prerequisites
- Git must be installed. Check with:  
git --version
- You must have a GitHub account and be logged in.

---
## 🧱 Step-by-Step Instructions

### 1. Create a New Repository on GitHub
- Go to [https://github.com](https://github.com)
- Click the **+** icon in the top right → **New repository**
- Enter a **Repository name**
- **Do NOT** initialize with a README, .gitignore, or license (you'll add those later)
- Click **Create repository**

---

### 2. Link Your Local Folder

Open Terminal (or Git Bash), then:

#### Navigate to your folder:
```bash
cd /path/to/your/folder
Initialize Git (if not already a repo):
git init
Add all files:
git add .
Commit the files:
git commit -m "Initial commit"
3. Connect to GitHub
Add the remote (replace with your repo URL):
git remote add origin https://github.com/your-username/your-repo-name.git
Push your code:
git push -u origin master
If you get an error with master, try main:
git push -u origin main
✅ Done!

Your local folder is now uploaded to GitHub. You can continue making changes, committing, and pushing updates from your local machine.
📌 Optional Tips

Add a .gitignore to avoid uploading temporary or build files
Use git status to check current changes
Use git log to view commit history

---

Let me know if you'd like this version to include `.gitignore` tips, license info, or deployment steps too!
