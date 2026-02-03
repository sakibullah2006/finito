#!/bin/bash

BASE_URL="http://localhost:8080/api/v1/profile"
EMAIL="validation_test_$(date +%s)@example.com"

echo "Validation Test Started for Email: $EMAIL"
echo "--------------------------------------------------"

# 1. Create User
echo "1. Testing POST $BASE_URL (Create User)..."
CREATE_RESPONSE=$(curl -s -X POST "$BASE_URL" \
  -H "Content-Type: application/json" \
  -d "{
    \"email\": \"$EMAIL\",
    \"displayName\": \"Validation User\",
    \"weight\": 75.5,
    \"height\": 180,
    \"currentGoal\": \"Maintenance\",
    \"dietaryRestrictions\": \"None\",
    \"dailyCalorieTarget\": 2200
  }")
echo "Response: $CREATE_RESPONSE"
USER_ID=$(echo $CREATE_RESPONSE | grep -o '"userId":"[^"]*"' | cut -d'"' -f4)

if [ -z "$USER_ID" ]; then
  echo "❌ Failed to create user or extract ID. Aborting."
  exit 1
fi
echo "✅ User Created with ID: $USER_ID"
echo ""

# 2. Get User
echo "2. Testing GET $BASE_URL (Get Profile)..."
GET_RESPONSE=$(curl -s -H "X-User-Id: $USER_ID" "$BASE_URL")
echo "Response: $GET_RESPONSE"
if [[ "$GET_RESPONSE" == *"$EMAIL"* ]]; then
  echo "✅ GET Profile Successful"
else
  echo "❌ GET Profile Failed"
fi
echo ""

# 3. Search User
echo "3. Testing GET $BASE_URL/search?email=... (Search User)..."
SEARCH_RESPONSE=$(curl -s "$BASE_URL/search?email=$EMAIL")
echo "Response: $SEARCH_RESPONSE"
if [[ "$SEARCH_RESPONSE" == *"$USER_ID"* ]]; then
  echo "✅ Search Profile Successful"
else
  echo "❌ Search Profile Failed"
fi
echo ""

# 4. Update User
echo "4. Testing PUT $BASE_URL (Update Profile)..."
UPDATE_RESPONSE=$(curl -s -X PUT "$BASE_URL" \
  -H "X-User-Id: $USER_ID" \
  -H "Content-Type: application/json" \
  -d '{
    "currentGoal": "Weight Loss",
    "weight": 74.0
  }')
echo "Response: $UPDATE_RESPONSE"
if [[ "$UPDATE_RESPONSE" == *"Weight Loss"* ]]; then
  echo "✅ Update Profile Successful"
else
  echo "❌ Update Profile Failed"
fi
echo ""

# 5. Delete User
echo "5. Testing DELETE $BASE_URL (Delete Profile)..."
DELETE_RESPONSE=$(curl -s -X DELETE "$BASE_URL" -H "X-User-Id: $USER_ID")
echo "Response: $DELETE_RESPONSE"
if [[ "$DELETE_RESPONSE" == *"DELETED"* ]]; then
  echo "✅ Delete Profile Successful"
else
  echo "❌ Delete Profile Failed"
fi

echo "--------------------------------------------------"
echo "Validation Test Completed"
