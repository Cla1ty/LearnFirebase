package com.kristal.analytics

import android.app.Application
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

/**
 * Created by Dwi_Ari on 11/2/17.
 */

object AnalyticsEvent {
    var analytics: FirebaseAnalytics? = null

    fun install(application: Application) {
        analytics = FirebaseAnalytics.getInstance(application)
    }

    fun addPaymentInfo() {
        analytics?.logEvent(FirebaseAnalytics.Event.ADD_PAYMENT_INFO, null)
    }

    fun addToCart(
            id: String,
            name: String,
            category: String,
            quantity: Long,
            price: Double? = null,
            value: Double? = null,
            currency: String? = null,
            origin: String? = null,
            itemLocationId: String? = null,
            destination: String? = null,
            startDate: String? = null,
            endDate: String? = null
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putString(FirebaseAnalytics.Param.ITEM_ID, id)
                putString(FirebaseAnalytics.Param.ITEM_NAME, name)
                putString(FirebaseAnalytics.Param.ITEM_CATEGORY, category)
                putLong(FirebaseAnalytics.Param.QUANTITY, quantity)

                if (price != null) putDouble(FirebaseAnalytics.Param.PRICE, price)
                if (value != null) putDouble(FirebaseAnalytics.Param.VALUE, value)
                if (currency != null) putString(FirebaseAnalytics.Param.CURRENCY, currency)
                if (origin != null) putString(FirebaseAnalytics.Param.ORIGIN, origin)
                if (itemLocationId != null) putString(FirebaseAnalytics.Param.ITEM_LOCATION_ID, itemLocationId)
                if (destination != null) putString(FirebaseAnalytics.Param.DESTINATION, destination)
                if (startDate != null) putString(FirebaseAnalytics.Param.START_DATE, startDate)
                if (endDate != null) putString(FirebaseAnalytics.Param.END_DATE, endDate)
            }
            logEvent(FirebaseAnalytics.Event.ADD_TO_CART, bundle)
        }
    }

    fun addToWhistlist(
            id: String,
            name: String,
            category: String,
            quantity: Long,
            price: Double? = null,
            value: Double? = null,
            currency: String? = null,
            itemLocationId: String? = null
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putString(FirebaseAnalytics.Param.ITEM_ID, id)
                putString(FirebaseAnalytics.Param.ITEM_NAME, name)
                putString(FirebaseAnalytics.Param.ITEM_CATEGORY, category)
                putLong(FirebaseAnalytics.Param.QUANTITY, quantity)

                if (price != null) putDouble(FirebaseAnalytics.Param.PRICE, price)
                if (value != null) putDouble(FirebaseAnalytics.Param.VALUE, value)
                if (currency != null) putString(FirebaseAnalytics.Param.CURRENCY, currency)
                if (itemLocationId != null) putString(FirebaseAnalytics.Param.ITEM_LOCATION_ID, itemLocationId)
            }
            logEvent(FirebaseAnalytics.Event.ADD_TO_CART, bundle)
        }
    }

    fun appOpen() {
        analytics?.logEvent(FirebaseAnalytics.Event.APP_OPEN, null)
    }

    fun beginCheckout(
            value: Double? = null,
            currency: String? = null,
            transactionId: String? = null,
            numberOfNights: Long? = null,
            numberOfRooms: Long? = null,
            numberOfPassengers: Long? = null,
            origin: String? = null,
            destination: String? = null,
            startDate: String? = null,
            endDate: String? = null,
            travelClass: String? = null
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                if (value != null) putDouble(FirebaseAnalytics.Param.VALUE, value)
                if (currency != null) putString(FirebaseAnalytics.Param.CURRENCY, currency)
                if (transactionId != null) putString(FirebaseAnalytics.Param.TRANSACTION_ID, transactionId)
                if (numberOfNights != null) putLong(FirebaseAnalytics.Param.NUMBER_OF_NIGHTS, numberOfNights)
                if (numberOfRooms != null) putLong(FirebaseAnalytics.Param.NUMBER_OF_ROOMS, numberOfRooms)
                if (numberOfPassengers != null) putLong(FirebaseAnalytics.Param.NUMBER_OF_PASSENGERS, numberOfPassengers)
                if (origin != null) putString(FirebaseAnalytics.Param.ORIGIN, origin)
                if (destination != null) putString(FirebaseAnalytics.Param.DESTINATION, destination)
                if (startDate != null) putString(FirebaseAnalytics.Param.START_DATE, startDate)
                if (endDate != null) putString(FirebaseAnalytics.Param.END_DATE, endDate)
                if (travelClass != null) putString(FirebaseAnalytics.Param.ITEM_LOCATION_ID, travelClass)
            }
            logEvent(FirebaseAnalytics.Event.ADD_TO_CART, bundle)
        }
    }

    fun campaignDetails(
            source: String,
            medium: String,
            campaign: String,
            term: String? = null,
            content: String? = null,
            aclid: String? = null,
            cp1: String? = null
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putString(FirebaseAnalytics.Param.SOURCE, source)
                putString(FirebaseAnalytics.Param.MEDIUM, medium)
                putString(FirebaseAnalytics.Param.CAMPAIGN, campaign)

                if (term != null) putString(FirebaseAnalytics.Param.TERM, term)
                if (content != null) putString(FirebaseAnalytics.Param.CONTENT, content)
                if (aclid != null) putString(FirebaseAnalytics.Param.ACLID, aclid)
                if (cp1 != null) putString(FirebaseAnalytics.Param.ITEM_LOCATION_ID, cp1)
            }
            logEvent(FirebaseAnalytics.Event.CAMPAIGN_DETAILS, bundle)
        }
    }

    fun checkoutProgress(
            checkoutStep: String,
            checkoutOption: String
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putString(FirebaseAnalytics.Param.CHECKOUT_STEP, checkoutStep)
                putString(FirebaseAnalytics.Param.CHECKOUT_OPTION, checkoutOption)
            }
            logEvent(FirebaseAnalytics.Event.CHECKOUT_PROGRESS, bundle)
        }
    }

    fun earnVirtualCurrency(
            virtualCurrencyName: String,
            value: Double
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putString(FirebaseAnalytics.Param.VIRTUAL_CURRENCY_NAME, virtualCurrencyName)
                putDouble(FirebaseAnalytics.Param.VALUE, value)
            }
            logEvent(FirebaseAnalytics.Event.EARN_VIRTUAL_CURRENCY, bundle)
        }
    }

    fun ecommercePurcase(
            currency: String? = null,
            value: Double? = null,
            transactionId: String? = null,
            tax: Double? = null,
            shipping: Double? = null,
            coupon: String? = null,
            location: String? = null,
            numberOfNights: Long? = null,
            numberOfRooms: Long? = null,
            numberOfPassengers: Long? = null,
            origin: String? = null,
            destination: String? = null,
            startDate: String? = null,
            endDate: String? = null,
            travelClass: String? = null
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                if (value != null) putDouble(FirebaseAnalytics.Param.VALUE, value)
                if (currency != null) putString(FirebaseAnalytics.Param.CURRENCY, currency)
                if (transactionId != null) putString(FirebaseAnalytics.Param.TRANSACTION_ID, transactionId)
                if (tax != null) putDouble(FirebaseAnalytics.Param.TAX, tax)
                if (shipping != null) putDouble(FirebaseAnalytics.Param.SHIPPING, shipping)
                if (coupon != null) putString(FirebaseAnalytics.Param.COUPON, coupon)
                if (location != null) putString(FirebaseAnalytics.Param.LOCATION, location)
                if (origin != null) putString(FirebaseAnalytics.Param.ORIGIN, origin)
                if (destination != null) putString(FirebaseAnalytics.Param.DESTINATION, destination)
                if (startDate != null) putString(FirebaseAnalytics.Param.START_DATE, startDate)
                if (endDate != null) putString(FirebaseAnalytics.Param.END_DATE, endDate)
                if (numberOfNights != null) putLong(FirebaseAnalytics.Param.NUMBER_OF_NIGHTS, numberOfNights)
                if (numberOfRooms != null) putLong(FirebaseAnalytics.Param.NUMBER_OF_ROOMS, numberOfRooms)
                if (numberOfPassengers != null) putLong(FirebaseAnalytics.Param.NUMBER_OF_PASSENGERS, numberOfPassengers)
                if (travelClass != null) putString(FirebaseAnalytics.Param.ITEM_LOCATION_ID, travelClass)
            }
            logEvent(FirebaseAnalytics.Event.ECOMMERCE_PURCHASE, bundle)
        }
    }

    fun generateLead(
            currency: String? = null,
            value: Double? = null
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                if (currency != null) putString(FirebaseAnalytics.Param.CURRENCY, currency)
                if (value != null) putDouble(FirebaseAnalytics.Param.VALUE, value)
            }
            logEvent(FirebaseAnalytics.Event.GENERATE_LEAD, bundle)
        }
    }

    fun joinGroup(
            groupId: String
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putString(FirebaseAnalytics.Param.GROUP_ID, groupId)
            }
            logEvent(FirebaseAnalytics.Event.JOIN_GROUP, bundle)
        }
    }

    fun levelUp(
            level: Long,
            character: String? = null
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putLong(FirebaseAnalytics.Param.LEVEL, level)
                if (character != null) putString(FirebaseAnalytics.Param.CHARACTER, character)
            }
            logEvent(FirebaseAnalytics.Event.LEVEL_UP, bundle)
        }
    }

    fun login() {
        analytics?.logEvent(FirebaseAnalytics.Event.LOGIN, null)
    }

    fun postScore(
            score: Long,
            level: Long? = null,
            character: String? = null
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putLong(FirebaseAnalytics.Param.SCORE, score)
                if (level != null) putLong(FirebaseAnalytics.Param.LEVEL, level)
                if (character != null) putString(FirebaseAnalytics.Param.CHARACTER, character)
            }
            logEvent(FirebaseAnalytics.Event.POST_SCORE, bundle)
        }
    }

    fun presentOffer(
            itemId: String,
            itemName: String,
            itemCategory: String,
            quantity: Long,
            price: Double? = null,
            value: Double? = null,
            currency: String? = null,
            itemLocationId: String? = null
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putString(FirebaseAnalytics.Param.ITEM_ID, itemId)
                putString(FirebaseAnalytics.Param.ITEM_NAME, itemName)
                putString(FirebaseAnalytics.Param.ITEM_CATEGORY, itemCategory)
                putLong(FirebaseAnalytics.Param.QUANTITY, quantity)

                if (price != null) putDouble(FirebaseAnalytics.Param.PRICE, price)
                if (value != null) putDouble(FirebaseAnalytics.Param.VALUE, value)
                if (currency != null) putString(FirebaseAnalytics.Param.CURRENCY, currency)
                if (itemLocationId != null) putString(FirebaseAnalytics.Param.ITEM_LOCATION_ID, itemLocationId)
            }
            logEvent(FirebaseAnalytics.Event.PRESENT_OFFER, bundle)
        }
    }

    fun purcaseRefund(
            currency: String? = null,
            value: Double? = null,
            transactionId: String? = null
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                if (currency != null) putString(FirebaseAnalytics.Param.CURRENCY, currency)
                if (value != null) putDouble(FirebaseAnalytics.Param.VALUE, value)
                if (transactionId != null) putString(FirebaseAnalytics.Param.TRANSACTION_ID, transactionId)
            }
            logEvent(FirebaseAnalytics.Event.PURCHASE_REFUND, bundle)
        }
    }

    fun removeFromCart(
            itemId: String,
            itemName: String,
            itemCategory: String,
            quantity: Long,
            price: Double? = null,
            value: Double? = null,
            currency: String? = null,
            origin: String? = null,
            itemLocationId: String? = null,
            destination: String? = null,
            startDate: String? = null,
            endDate: String? = null
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putString(FirebaseAnalytics.Param.ITEM_ID, itemId)
                putString(FirebaseAnalytics.Param.ITEM_NAME, itemName)
                putString(FirebaseAnalytics.Param.ITEM_CATEGORY, itemCategory)
                putLong(FirebaseAnalytics.Param.QUANTITY, quantity)

                if (price != null) putDouble(FirebaseAnalytics.Param.PRICE, price)
                if (value != null) putDouble(FirebaseAnalytics.Param.VALUE, value)
                if (currency != null) putString(FirebaseAnalytics.Param.CURRENCY, currency)
                if (origin != null) putString(FirebaseAnalytics.Param.ORIGIN, origin)
                if (itemLocationId != null) putString(FirebaseAnalytics.Param.ITEM_LOCATION_ID, itemLocationId)
                if (destination != null) putString(FirebaseAnalytics.Param.DESTINATION, destination)
                if (startDate != null) putString(FirebaseAnalytics.Param.START_DATE, startDate)
                if (endDate != null) putString(FirebaseAnalytics.Param.END_DATE, endDate)
            }
            logEvent(FirebaseAnalytics.Event.REMOVE_FROM_CART, bundle)
        }
    }

    fun search(
            searchTerm: String,
            numberOfNights: Long? = null,
            numberOfRooms: Long? = null,
            numberOfPassengers: Long? = null,
            origin: String? = null,
            destination: String? = null,
            startDate: String? = null,
            endDate: String? = null,
            travelClass: String? = null
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putString(FirebaseAnalytics.Param.SEARCH_TERM, searchTerm)
                if (origin != null) putString(FirebaseAnalytics.Param.ORIGIN, origin)
                if (destination != null) putString(FirebaseAnalytics.Param.DESTINATION, destination)
                if (startDate != null) putString(FirebaseAnalytics.Param.START_DATE, startDate)
                if (endDate != null) putString(FirebaseAnalytics.Param.END_DATE, endDate)
                if (numberOfNights != null) putLong(FirebaseAnalytics.Param.NUMBER_OF_NIGHTS, numberOfNights)
                if (numberOfRooms != null) putLong(FirebaseAnalytics.Param.NUMBER_OF_ROOMS, numberOfRooms)
                if (numberOfPassengers != null) putLong(FirebaseAnalytics.Param.NUMBER_OF_PASSENGERS, numberOfPassengers)
                if (travelClass != null) putString(FirebaseAnalytics.Param.ITEM_LOCATION_ID, travelClass)
            }
            logEvent(FirebaseAnalytics.Event.SEARCH, bundle)
        }
    }

    fun selectContent(
            contentType: String,
            itemId: String
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putString(FirebaseAnalytics.Param.CONTENT_TYPE, contentType)
                putString(FirebaseAnalytics.Param.ITEM_ID, itemId)
            }
            logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
        }
    }

    fun setCheckoutOption(
            checkoutStep: String,
            checkoutOption: String
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putString(FirebaseAnalytics.Param.CHECKOUT_STEP, checkoutStep)
                putString(FirebaseAnalytics.Param.CHECKOUT_OPTION, checkoutOption)
            }
            logEvent(FirebaseAnalytics.Event.SET_CHECKOUT_OPTION, bundle)
        }
    }

    fun share(
            contentType: String,
            itemId: String
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putString(FirebaseAnalytics.Param.CONTENT_TYPE, contentType)
                putString(FirebaseAnalytics.Param.ITEM_ID, itemId)
            }
            logEvent(FirebaseAnalytics.Event.SHARE, bundle)
        }
    }

    fun signUp(
            signUpMethod: String
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putString(FirebaseAnalytics.Param.SIGN_UP_METHOD, signUpMethod)
            }
            logEvent(FirebaseAnalytics.Event.SIGN_UP, bundle)
        }
    }

    fun spendVirtualCurrency(
            itemName: String,
            virtualCurrencyName: String,
            value: Double
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putString(FirebaseAnalytics.Param.ITEM_NAME, itemName)
                putString(FirebaseAnalytics.Param.VIRTUAL_CURRENCY_NAME, virtualCurrencyName)
                putDouble(FirebaseAnalytics.Param.VALUE, value)
            }
            logEvent(FirebaseAnalytics.Event.SPEND_VIRTUAL_CURRENCY, bundle)
        }
    }

    fun tutorialBegin() {
        analytics?.logEvent(FirebaseAnalytics.Event.TUTORIAL_BEGIN, null)
    }

    fun tutorialComplete() {
        analytics?.logEvent(FirebaseAnalytics.Event.TUTORIAL_COMPLETE, null)
    }

    fun unlockAchievement(
            achievementId: String
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putString(FirebaseAnalytics.Param.ACHIEVEMENT_ID, achievementId)
            }
            logEvent(FirebaseAnalytics.Event.UNLOCK_ACHIEVEMENT, bundle)
        }
    }

    fun viewItem(
            id: String,
            name: String,
            category: String,
            itemLocationId: String? = null,
            price: Double? = null,
            quantity: Long? = null,
            currency: String? = null,
            value: Double? = null,
            flightNumber: String? = null,
            numberOfNights: Long? = null,
            numberOfRooms: Long? = null,
            numberOfPassengers: Long? = null,
            origin: String? = null,
            destination: String? = null,
            startDate: String? = null,
            endDate: String? = null,
            travelClass: String? = null,
            searchTerm: String? = null
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putString(FirebaseAnalytics.Param.ITEM_ID, id)
                putString(FirebaseAnalytics.Param.ITEM_NAME, name)
                putString(FirebaseAnalytics.Param.ITEM_CATEGORY, category)
                if (itemLocationId != null) putString(FirebaseAnalytics.Param.ITEM_LOCATION_ID, itemLocationId)
                if (quantity != null) putLong(FirebaseAnalytics.Param.QUANTITY, quantity)
                if (price != null) putDouble(FirebaseAnalytics.Param.PRICE, price)
                if (value != null) putDouble(FirebaseAnalytics.Param.VALUE, value)
                if (currency != null) putString(FirebaseAnalytics.Param.CURRENCY, currency)
                if (flightNumber != null) putString(FirebaseAnalytics.Param.FLIGHT_NUMBER, flightNumber)
                if (origin != null) putString(FirebaseAnalytics.Param.ORIGIN, origin)
                if (destination != null) putString(FirebaseAnalytics.Param.DESTINATION, destination)
                if (startDate != null) putString(FirebaseAnalytics.Param.START_DATE, startDate)
                if (endDate != null) putString(FirebaseAnalytics.Param.END_DATE, endDate)
                if (numberOfNights != null) putLong(FirebaseAnalytics.Param.NUMBER_OF_NIGHTS, numberOfNights)
                if (numberOfRooms != null) putLong(FirebaseAnalytics.Param.NUMBER_OF_ROOMS, numberOfRooms)
                if (numberOfPassengers != null) putLong(FirebaseAnalytics.Param.NUMBER_OF_PASSENGERS, numberOfPassengers)
                if (travelClass != null) putString(FirebaseAnalytics.Param.ITEM_LOCATION_ID, travelClass)
                if (searchTerm != null) putString(FirebaseAnalytics.Param.SEARCH_TERM, searchTerm)
            }
            logEvent(FirebaseAnalytics.Event.VIEW_ITEM, bundle)
        }
    }

    fun viewItemList(
            itemCategory: String
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putString(FirebaseAnalytics.Param.ITEM_CATEGORY, itemCategory)
            }
            logEvent(FirebaseAnalytics.Event.VIEW_ITEM_LIST, bundle)
        }
    }

    fun viewSearchResult(
            searchTerm: String
    ) {
        analytics?.apply {
            val bundle = Bundle().apply {
                putString(FirebaseAnalytics.Param.SEARCH_TERM, searchTerm)
            }
            logEvent(FirebaseAnalytics.Event.VIEW_SEARCH_RESULTS, bundle)
        }
    }
}