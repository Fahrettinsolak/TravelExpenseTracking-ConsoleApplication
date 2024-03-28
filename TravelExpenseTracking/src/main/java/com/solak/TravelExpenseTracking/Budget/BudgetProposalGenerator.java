package com.solak.TravelExpenseTracking.Budget;

public class BudgetProposalGenerator {

    // Belirli bir seyahat türü ve hedefine göre bütçe önerisi oluşturma yöntemi
    public Budget createBudgetProposal(String tripType, String destination) {
        // Ortalama harcama değerleri
        double averageAccommodationCost;
        double averageTransportationCost;
        double averageFoodCost;

        // Seyahat türüne göre ortalama konaklama maliyeti belirleme
        if (tripType.equalsIgnoreCase("city")) {
            averageAccommodationCost = 100; // Şehir içi seyahatler için ortalama konaklama maliyeti
        } else if (tripType.equalsIgnoreCase("beach")) {
            averageAccommodationCost = 150; // Plaj tatilleri için ortalama konaklama maliyeti
        } else {
            averageAccommodationCost = 120; // Varsayılan değer
        }

        // Hedefe göre ortalama ulaşım maliyeti belirleme
        if (destination.equalsIgnoreCase("Europe")) {
            averageTransportationCost = 200; // Avrupa seyahatleri için ortalama ulaşım maliyeti
        } else if (destination.equalsIgnoreCase("Asia")) {
            averageTransportationCost = 250; // Asya seyahatleri için ortalama ulaşım maliyeti
        } else {
            averageTransportationCost = 220; // Varsayılan değer
        }

        // Ortalama yemek maliyeti
        averageFoodCost = 30; // Bir öğün yemeğin ortalama maliyeti

        // Toplam ortalama harcama hesaplama
        double totalAverageCost = averageAccommodationCost + averageTransportationCost + averageFoodCost;

        // Bütçe önerisi oluşturma
        Budget budgetProposal = new Budget(totalAverageCost, "USD", "Average expenses based on trip type and destination", "Per Person", "Total");

        return budgetProposal;
    }
}
