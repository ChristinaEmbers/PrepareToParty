# PrepareToParty

Ein Java/JavaFX-Partyplanungsspiel, das strategische Entscheidungen mit Ressourcenmanagement verbindet. Entwickelt zur Vertiefung von Java-Kenntnissen und zur praktischen Anwendung von Architekturmustern.

## Projektübersicht

**PrepareToParty** ist ein strategisches Spiel, bei dem der Spieler eine Party plant und dabei die perfekte Balance zwischen Essen, Dekoration und Aktivitäten finden muss. Das Ziel ist es, die höchstmögliche Punktzahl zu erreichen, während die verfügbaren Ressourcen (Energie, Zeit, Geld) optimal eingesetzt werden.

### Gameplay-Konzept
- Auswahl aus verschiedenen Optionen für Essen, Dekoration und Aktivitäten
- Jede Wahl beeinflusst die Gesamtpunktzahl und verbraucht Ressourcen
- Strategische Planung erforderlich, um sowohl durch gewählte Optionen als auch durch effiziente Ressourcennutzung Punkte zu maximieren

## Technische Details

- **Sprache:** Java 24
- **UI Framework:** JavaFX
- **Build-Tool:** Maven
- **Architektur:** Model-View-Controller (MVC)
- **Dependencies:** Ausschließlich JavaFX (keine externen Libraries)

## Architektur & Design-Entscheidungen

### MVC-Architektur
Das Projekt folgt dem bewährten MVC-Pattern für klare Trennung der Verantwortlichkeiten:
- **Model:** Model Klassen für Spielelemente und Datenstrukturen
- **View:** JavaFX-basierte Benutzeroberfläche
- **Controller:** GameController für UI-Interaktionen und Programmfluss

### Zentrale Architekturlösung: ActionBuilder-Pattern
Eine der Hauptherausforderungen war die effiziente Datenübertragung zwischen Action-Modellen und dem GameController. Die implementierte Lösung:

```java
ActionBuilder erstellt 9 Action-Objekte (3 pro Kategorie)
              
GameController  empfängt Action-Array
              
HashMap<String, Action[]> organisiert Actions nach Kategorien
```

**Vorteile dieser Architektur:**
- Saubere Trennung von Datenkreierung und -verwendung
- Skalierbare Struktur für zusätzliche Kategorien
- Effiziente Zugriffsmuster durch HashMap-Organisation
- Wiederverwendbare ActionBuilder-Komponente

## Lernziele & Entwicklungsansatz

### Primäre Lernziele
- **Praktische Anwendung** von Java-Konzepten aus dem Kurs
- **Eigenständige Projektentwicklung** von Konzept bis Implementierung
- **Architekturentscheidungen** selbstständig treffen und umsetzen
- **JavaFX-Grundlagen** in einem realen Projekt anwenden
- **MVC-Pattern** praktisch implementieren

### Entwicklungsansatz
Das Projekt ermöglicht es, durch eigenständige Problemlösung Schwachstellen zu identifizieren und kontinuierlich zu verbessern. Der Fokus liegt auf dem vollständigen Entwicklungszyklus - von der Konzeption bis zur Fertigstellung.

## Geplante Weiterentwicklung

### Qualitätssicherung
- **Code-Review** mit Kollegen zur Verbesserung der Lesbarkeit und Wartbarkeit
- **Refactoring** basierend auf Feedback und Best Practices

### Technologie-Erweiterung
- **JavaScript-Port** zur Vertiefung von Web-Technologien (HTML, CSS, JavaScript)
- **Übergang zu Spring Framework** für das nächste Projekt

## Projektziele

Dieses Projekt demonstriert:
- Selbstständige Planung und Umsetzung eines Software-Projekts
- Anwendung von Architekturmustern in der Praxis
- Problemlösungskompetenz bei Design-Herausforderungen
- Strukturierte Herangehensweise an komplexe Entwicklungsaufgaben
- Bereitschaft zur kontinuierlichen Verbesserung und zum Lernen

---

*Entwickelt als Lernprojekt zur Vertiefung von Java-Kenntnissen und zur Vorbereitung auf fortgeschrittene Frameworks wie Spring.*
