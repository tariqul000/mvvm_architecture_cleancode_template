package com.tariqul.alet

sealed class MediaType(val type: String) {

    object Banner : MediaType(BANNER)
    object Gallery : MediaType(GALLERY)
    object Image : MediaType(IMAGE)
    object Link : MediaType(LINK)
    object Icon : MediaType(ICON)
    object Youtube : MediaType(YOUTUBE)
    object Video : MediaType(VIDEO)
    object Unknown : MediaType(UNKNOWN)

    companion object {
        private const val BANNER = "BANNER"
        private const val GALLERY = "GALLERY"
        private const val IMAGE = "IMAGE"
        private const val LINK = "LINK"
        private const val ICON = "ICON"
        private const val YOUTUBE = "YOUTUBE-VIDEO"
        private const val VIDEO = "VIDEO"
        private const val UNKNOWN = "UNKNOWN"

        fun hasImage(group: String, type: String): Boolean {
            return getType(group) is Gallery && getType(type) is Image
        }

        fun hasIcon(group: String): Boolean {
            return getType(group) is Icon
        }

        fun hasVideo(group: String, type: String): Boolean {
            return getType(group) is Video && getType(type) is Youtube
        }

        fun hasLink(group: String, type: String): Boolean {
            return getType(group) is Link && getType(type) is Link
        }

        private fun getType(type: String): MediaType {
            return when (type) {
                BANNER -> Banner
                GALLERY -> Gallery
                IMAGE -> Image
                LINK -> Link
                ICON -> Icon
                YOUTUBE -> Youtube
                VIDEO -> Video
                else -> Unknown
            }
        }
    }


}