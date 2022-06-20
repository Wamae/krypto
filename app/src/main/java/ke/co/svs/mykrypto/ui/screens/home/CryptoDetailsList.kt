/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ke.co.svs.mykrypto.ui.screens.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ke.co.svs.mykrypto.domain.model.Crypto
import ke.co.svs.mykrypto.domain.model.CryptoDetails
import ke.co.svs.mykrypto.ui.components.CryptoDetailsListItem
import ke.co.svs.mykrypto.ui.components.CryptoListItem


@Composable
fun CryptoDetailsList(
    list: List<CryptoDetails>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            /**
             * Use key param to define unique keys representing the items in a mutable list,
             * instead of using the default key (list position). This prevents unnecessary
             * recompositions.
             */
            key = { cryptoDetails -> cryptoDetails.id }
        ) { cryptoDetails ->
            CryptoDetailsListItem(
                cryptoDetails = cryptoDetails,
                onClick = {},
                modifier = modifier
            )
        }
    }
}

