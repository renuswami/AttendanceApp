package com.example.teamtime.firebasefirestore

import android.util.Log
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/*
private fun sendDataToFirebase(
    androidId: String,
    latitude: Double,
    longitude: Double,
    time: String
) {
    // Initialize the Firestore reference
    val firestore = FirebaseFirestore.getInstance()

    // Data to be stored
    val data = hashMapOf(
        "androidId" to androidId,
        "latitude" to latitude,
        "longitude" to longitude,
        "time" to time
    )

    // Add data to the "employees" collection
    firestore.collection("employees")
        .add(data)
        .addOnSuccessListener { documentReference ->
            println("Data successfully written with ID: ${documentReference.id}")
        }
        .addOnFailureListener { error ->
            println("Failed to write data to Firebase Firestore: ${error.message}")
        }
}

fun checkAndUpdateData(androidId: String, latitude: Double, longitude: Double, time: String) {
    val db = FirebaseFirestore.getInstance()

    // Reference to the "employees" collection
    val employeesRef = db.collection("employees")

    // Parse the time to get the date
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val currentDate = try {
        dateFormat.parse(time)
    } catch (e: ParseException) {
        e.printStackTrace()
        null
    }

    if (currentDate != null) {
        // Fetch the existing records with the same androidId and date
        employeesRef
            .whereEqualTo("androidId", androidId)
            .get()
            .addOnSuccessListener { data ->
                val matchingEntries = mutableListOf<DocumentSnapshot>()

                // Loop through the data to find records with the same date
                for (document in data) {
                    val existingTime = document.getString("time")
                    val existingDate = try {
                        dateFormat.parse(existingTime)
                    } catch (e: ParseException) {
                        null
                    }

                    // If the dates match, add the entry to the matchingEntries list
                    if (existingDate != null && isSameDay(currentDate, existingDate)) {
                        matchingEntries.add(document)
                    }
                }

                // Check how many matching entries were found
                when (matchingEntries.size) {
                    0 -> {
                        // If no matching entries found, insert the new data
                        sendDataToFirebase(androidId, latitude, longitude, time)
                    }
                    1 -> {
                        // If exactly one matching entry is found, update it (this would be the first entry)
                        sendDataToFirebase(androidId, latitude, longitude, time)
                    }
                    2 -> {
                        // If two matching entries are found, update the second one
                        val secondEntry = matchingEntries[1]
                        val documentId = secondEntry.id
                        val updatedData = hashMapOf(
                            "androidId" to androidId,
                            "latitude" to latitude,
                            "longitude" to longitude,
                            "time" to time
                        )

                        // Update the second entry in Firestore
                        employeesRef.document(documentId)
                            .set(updatedData)
                            .addOnSuccessListener {
                                println("Second entry updated successfully.")
                            }
                            .addOnFailureListener { error ->
                                println("Failed to update second entry: ${error.message}")
                            }
                    }
                    else -> {
                        println("Error: More than two matching entries found.")
                    }
                }
            }
            .addOnFailureListener { e ->
                Log.d("FirestoreData", e.toString())
                println("Error fetching documents: $e")
            }
    }
}

// Utility function to check if two dates are the same day
fun isSameDay(date1: Date, date2: Date): Boolean {
    val cal1 = Calendar.getInstance()
    cal1.time = date1
    val cal2 = Calendar.getInstance()
    cal2.time = date2

    return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
            cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
            cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH)
}
*/
