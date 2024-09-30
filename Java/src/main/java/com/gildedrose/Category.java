package com.gildedrose;

public enum Category {

    NORMAL {
        @Override
        void updateQuality(QualityUpdater qualityUpdater, Item item) {
            qualityUpdater.updateQualityNormal(item);
        }
    },
    AGING {
        @Override
        void updateQuality(QualityUpdater qualityUpdater, Item item) {
            qualityUpdater.updateQualityAging(item);
        }
    },
    LEGENDARY{
        @Override
        void updateQuality(QualityUpdater qualityUpdater, Item item) {
            qualityUpdater.updateQualityLegendary(item);
        }
    },
    CONCERT_TICKET {
        @Override
        void updateQuality(QualityUpdater qualityUpdater, Item item) {
            qualityUpdater.updateQualityConcertTicket(item);
        }
    },
    CONJURED {
        @Override
        void updateQuality(QualityUpdater qualityUpdater, Item item) {
            qualityUpdater.updateQualityConjured(item);
        }
    };

    abstract void updateQuality(QualityUpdater qualityUpdater, Item item);

}
