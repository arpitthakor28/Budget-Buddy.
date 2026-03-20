-- Supabase Setup Script for Money App
-- Run this in the Supabase SQL Editor (https://app.supabase.com/project/_/sql)

-- 1. Create Users Table
CREATE TABLE IF NOT EXISTS users (
    username TEXT PRIMARY KEY,
    password TEXT,
    name TEXT,
    email TEXT,
    phone TEXT,
    photo_path TEXT,
    base_currency TEXT,
    risk_profile TEXT,
    created_at TIMESTAMPTZ DEFAULT NOW()
);

-- 2. Create Transactions Table
CREATE TABLE IF NOT EXISTS transactions (
    id TEXT PRIMARY KEY,
    username TEXT REFERENCES users(username) ON DELETE CASCADE,
    amount DECIMAL,
    category TEXT,
    description TEXT,
    type TEXT,
    date DATE,
    created_at TIMESTAMPTZ DEFAULT NOW()
);

-- 3. Create Budget Categories Table
CREATE TABLE IF NOT EXISTS budget_categories (
    username TEXT REFERENCES users(username) ON DELETE CASCADE,
    category_name TEXT,
    monthly_limit DECIMAL,
    PRIMARY KEY (username, category_name),
    created_at TIMESTAMPTZ DEFAULT NOW()
);

-- 4. Create Trips Table (Using JSON storage as per TripService)
CREATE TABLE IF NOT EXISTS trips (
    username TEXT PRIMARY KEY REFERENCES users(username) ON DELETE CASCADE,
    data JSONB,
    updated_at TIMESTAMPTZ DEFAULT NOW()
);

-- 5. Create Loans Table (Using JSON storage as per LoanService)
CREATE TABLE IF NOT EXISTS loans (
    username TEXT PRIMARY KEY REFERENCES users(username) ON DELETE CASCADE,
    data JSONB,
    updated_at TIMESTAMPTZ DEFAULT NOW()
);

-- Enable Row Level Security (RLS)
ALTER TABLE users ENABLE ROW LEVEL SECURITY;
ALTER TABLE transactions ENABLE ROW LEVEL SECURITY;
ALTER TABLE budget_categories ENABLE ROW LEVEL SECURITY;
ALTER TABLE trips ENABLE ROW LEVEL SECURITY;
ALTER TABLE loans ENABLE ROW LEVEL SECURITY;

-- Create Policies (Allow all for anon for now, or refine if needed)
-- Note: Replace 'anon' with authenticated if you use Supabase Auth
DROP POLICY IF EXISTS "Enable all access for all" ON users;
CREATE POLICY "Enable all access for all" ON users FOR ALL USING (true) WITH CHECK (true);

DROP POLICY IF EXISTS "Enable all access for all" ON transactions;
CREATE POLICY "Enable all access for all" ON transactions FOR ALL USING (true) WITH CHECK (true);

DROP POLICY IF EXISTS "Enable all access for all" ON budget_categories;
CREATE POLICY "Enable all access for all" ON budget_categories FOR ALL USING (true) WITH CHECK (true);

DROP POLICY IF EXISTS "Enable all access for all" ON trips;
CREATE POLICY "Enable all access for all" ON trips FOR ALL USING (true) WITH CHECK (true);

DROP POLICY IF EXISTS "Enable all access for all" ON loans;
CREATE POLICY "Enable all access for all" ON loans FOR ALL USING (true) WITH CHECK (true);
