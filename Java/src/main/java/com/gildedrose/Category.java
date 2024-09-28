package com.gildedrose;

public enum Category {

    NORMAL {
        void updateQuality(QualityUpdater qualityUpdater, Item item) {
            qualityUpdater.updateQualityNormal(item);
        }
    },
    AGING {
        void updateQuality(QualityUpdater qualityUpdater, Item item) {
            qualityUpdater.updateQualityAging(item);
        }
    },
    LEGENDARY{
        void updateQuality(QualityUpdater qualityUpdater, Item item) {
            qualityUpdater.updateQualityLegendary(item);
        }
    },
    CONCERT_TICKET {
        void updateQuality(QualityUpdater qualityUpdater, Item item) {
            qualityUpdater.updateQualityConcertTicket(item);
        }
    },
    CONJURED {
        void updateQuality(QualityUpdater qualityUpdater, Item item) {
            qualityUpdater.updateQualityConjured(item);
        }
    };

    abstract void updateQuality(QualityUpdater qualityUpdater, Item item);

}
