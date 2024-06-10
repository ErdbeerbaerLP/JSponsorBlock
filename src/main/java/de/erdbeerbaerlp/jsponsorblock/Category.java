package de.erdbeerbaerlp.jsponsorblock;

public enum Category {
    /**
     * Paid promotion, paid referrals and direct advertisements. Not for self-promotion or free shoutouts to causes/creators/websites/products they like.
     */
    SPONSOR,
    /**
     * Similar to "sponsor" except for unpaid or self promotion. This includes sections about merchandise, donations, or information about who they collaborated with.
     */
    SELFPROMO,
    /**
     * When there is a short reminder to like, subscribe or follow them in the middle of content. If it is long or about something specific, it should be under self promotion instead.
     */
    INTERACTION,
    /**
     * An interval without actual content. Could be a pause, static frame, repeating animation. This should not be used for transitions containing information.
     */
    INTRO,
    /**
     * Credits or when the YouTube endcards appear. Not for conclusions with information.
     */
    OUTRO,
    /**
     * Collection of clips that show what is coming up in in this video or other videos in a series where all information is repeated later in the video.
     */
    PREVIEW,

    /**
     * Only for use in music videos. This only should be used for sections of music videos that aren't already covered by another category.
     */
    MUSIC_OFFTOPIC,
    /**
     * Tangential scenes added only for filler or humor that are not required to understand the main content of the video. This should not include segments providing context or background details. This is a very aggressive category meant for when you aren't in the mood for "fun".
     */
    FILLER;
}
